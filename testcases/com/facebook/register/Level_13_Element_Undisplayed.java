package com.facebook.register;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verified_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();

		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verified_Element_Undisplayed_In_DOM() {
		loginPage.enterToEmailAddressTextbox("doan@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@Test
	public void TC_03_Verified_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);

		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver driver;

}
