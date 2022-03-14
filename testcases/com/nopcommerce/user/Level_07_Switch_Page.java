package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrderPageObject orderPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserAddressPageObject addressPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Doan";
		lastName = "Nguyen";
		emailAddress = "doannguyen" + generateFakeNumber() + "@gmail.vn";
		password = "123456";
	}

	@Test
	public void TC_01_Register_To_System() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void TC_03_My_Account_Infor() {
		customerInfoPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerInfoPage.getFirstNameText(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameText(), lastName);
		Assert.assertEquals(customerInfoPage.getEmailAddressText(), emailAddress);

		homePage = customerInfoPage.clickToSaveButton();
	}

	@Test
	public void TC_04_Navigate_Page(){
		orderPage = customerInfoPage.openOrderPage(driver);
		
		rewardPointPage = orderPage.openRewardPointPage(driver);
		
		orderPage = rewardPointPage.openOrderPage(driver);
		
		customerInfoPage = orderPage.openCustomerInfoPage(driver);
		 
		addressPage = customerInfoPage.openAddressPage(driver);
		
		rewardPointPage = addressPage.openRewardPointPage(driver);
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
