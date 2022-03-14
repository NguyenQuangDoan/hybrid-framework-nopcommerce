package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalContants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.UserHomePageObject;

public class Level_08_Switch_Role_Admin extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private AdminLoginPageObject adminLogin;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalContants.ADMIN_URL);
		adminLogin = PageGeneratorManager.getAdminLoginPage(driver);
	}

	@Test
	public void TC_01_Switch_User_To_Admin() {
		
	}

	@Test
	public void TC_02_Switch_Admin_To_User() {
		
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
