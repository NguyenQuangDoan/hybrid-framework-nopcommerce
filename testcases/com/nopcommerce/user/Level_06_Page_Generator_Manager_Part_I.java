package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.users.UserCustomerInfoPageObject;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_Part_I extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject myAccountPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = new UserHomePageObject(driver);
		firstName = "Doan";
		lastName = "Nguyen";
		emailAddress = "doannguyen" + generateFakeNumber() + "@gmail.vn";
		password = "123456";
	}

	@Test
	public void TC_01_Register_To_System() {
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void TC_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		homePage = new UserHomePageObject(driver);

	}

	@Test
	public void TC_03_My_Account_Infor() {
		homePage.clickToMyAccountLink();
		myAccountPage = new UserCustomerInfoPageObject(driver);

		Assert.assertEquals(myAccountPage.getFirstNameText(), firstName);
		Assert.assertEquals(myAccountPage.getLastNameText(), lastName);
		Assert.assertEquals(myAccountPage.getEmailAddressText(), emailAddress);

		myAccountPage.clickToSaveButton();
		
		homePage = new UserHomePageObject(driver);
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
