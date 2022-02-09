package com.jquery;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalContants;
import pageObjectJQuery.dataTable.PageGeneratorManager;
import pageObjectJQuery.dataTable.adminDashboardPageObject;
import pageObjectJQuery.dataTable.adminLoginPageObject;
import pageObjectJQuery.dataTable.homePageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	homePageObject homePage;
	adminLoginPageObject adminLoginPage;
	adminDashboardPageObject adminDashboardPage;

	private String adminEmailAddress, adminPassword, userEmail;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

		userEmail = "doannguyen" + generateFakeNumber() + "@gmail.vn";
		adminEmailAddress = "user01";
		adminPassword = "guru99com";
	}

	public void TC_01_Paging() {
		homePage.openPagingPageNumber("10");
		verifyTrue(homePage.isPageNumberActive("10"));
	}

	public void TC_02_Enter_To_Header() {
		homePage.refreshPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "Afghanistan");
		verifyTrue(homePage.isDataFilterByTotalHeader("791312"));
		homePage.sleepInSecond(3);
	}

	public void TC_03_Enter_To_Header() {
		homePage.refreshPage(driver);
		homePage.getRowValueAtAllPage();
	}

	public void TC_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();

//		homePage.enterToTextboxByColumnNameAtRowNumber("Album", "4", "Michael 97");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "5", "Michael Jackson");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Year", "3", "1997");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Price", "1", "$40");
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "2", "Korea");
//		
//		homePage.checkToCheckboxByColumNameAtRowNumber("With Poster?", "3");
//		homePage.checkToCheckboxByColumNameAtRowNumber("With Poster?", "5");
//		
//		homePage.uncheckToCheckboxByColumNameAtRowNumber("With Poster?", "1");
//		homePage.uncheckToCheckboxByColumNameAtRowNumber("With Poster?", "2");
//		homePage.uncheckToCheckboxByColumNameAtRowNumber("With Poster?", "4");

		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.clickToIconByRowNumber("4", "Move Down");
	}

//	exercise
	@Test
	public void TC_05_Register_Account() {
		homePage.clickToMyAccountLink();
		homePage.clickToCreateAnAccountButton();
		homePage.fillFirstNameToTextbox("Doan");
		homePage.fillLastNameToTextbox("Nguyen");
		homePage.fillEmailToTextbox(userEmail);
		homePage.fillPasswordToTextbox("123456");
		homePage.fillComfirmPasswordToTextbox("123456");
		homePage.clickToRegisterButton();

		verifyEquals(homePage.getRegisteredSuccessMessage(), "Thank you for registering with Main Website Store.");

		homePage.openUrl(driver, GlobalContants.GURU_ADMIN_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		adminDashboardPage.closeThePopupMessage();
		adminDashboardPage.enterToTextboxByColumnNameAtColumnNumber("Email", "4", userEmail);
		adminDashboardPage.clickSearchButton();

		verifyTrue(adminDashboardPage.userInfoIsDisplayed("Doan Nguyen", userEmail));
	}

	@Test
	public void TC_06_Delete_Account() {
		adminDashboardPage.clickCheckboxAccount("1", "1");
		adminDashboardPage.selectDeleteOption("Delete");
		adminDashboardPage.clickSubmitButton();
		adminDashboardPage.acceptAlertPopup();

		verifyEquals(driver, GlobalContants.GURU_USER_LOGIN_URL);

		homePage = PageGeneratorManager.getHomePage(driver);

		homePage.loginAsUser(userEmail, "123456");
		verifyEquals(homePage.getNoResultForAccount(), "Invalid login or password.");
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
