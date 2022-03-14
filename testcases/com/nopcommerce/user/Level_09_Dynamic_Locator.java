package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.UserAddressPageObject;
import pageObjects.users.UserCustomerInfoPageObject;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserOrderPageObject;
import pageObjects.users.UserRegisterPageObject;
import pageObjects.users.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrderPageObject orderPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserAddressPageObject addressPage;
	private String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = "doannguyen123@gmail.net";
		password = "123456";
	}

	@Test
	public void TC_01_Login_To_System() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void TC_02_Dynamic_Page_01() {
		customerInfoPage = homePage.clickToMyAccountLink();
		
		addressPage = (UserAddressPageObject) customerInfoPage.openPagesAtMyAccountPageByName(driver, "Address");

		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountPageByName(driver, "Reward point");

		orderPage = (UserOrderPageObject) rewardPointPage.openPagesAtMyAccountPageByName(driver, "Order");
	}
	
	@Test
	public void TC_03_Dynamic_Page_02() {
		orderPage.openPagesAtMyAccountByPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "Address");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		addressPage.openPagesAtMyAccountByPageName(driver, "Reward point");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Order");
		orderPage = PageGeneratorManager.getUserOrderPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
