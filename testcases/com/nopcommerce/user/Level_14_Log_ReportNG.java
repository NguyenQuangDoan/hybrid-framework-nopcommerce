package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.UserCustomerInfoPageObject;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPageObject;

public class Level_14_Log_ReportNG extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "John";
		lastName = "Terry";
		emailAddress = "johnterry" + generateFakeNumber() + "@mail.net";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Click to Login button");
		customerInfoPage = homePage.clickToMyAccountLink();

		log.info("Login - Step 06: Enter to Firstname textbox with value is '" + firstName + "'");
		verifyEquals(customerInfoPage.getFirstNameText(), firstName);

		log.info("Login - Step 07: Enter to Lastname textbox with value is '" + lastName + "'");
		verifyEquals(customerInfoPage.getLastNameText(), lastName);

		log.info("Login - Step 08: Enter to Email textbox with value is '" + emailAddress + "'");
		verifyEquals(customerInfoPage.getEmailAddressText(), emailAddress);

	}

	@AfterClass()
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
