package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsJQuery.uploadFiles.PageGeneratorManager;
import pageObjectsJQuery.uploadFiles.homePageObject;

public class Level_15_ExtentV3_Screenshot extends BaseTest {
	String dalatFileName = "Dalat.jpg";
	String hueFileName = "Hue.jpg";
	String sapaFileName = "Sapa.jpg";

	String[] multipleFileNames = { dalatFileName, hueFileName, sapaFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Upload_Once_File_Per_Time(Method method) {
		homePage.uploadMultipleFiles(driver, dalatFileName);

		verifyTrue(homePage.isLoadedByFileName(dalatFileName));

		homePage.clickToStartButton();

		verifyTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));

		verifyTrue(homePage.isUpLoadedImageByFileName(hueFileName));
	}

	@Test
	public void TC_02_Upload_Multiple_Files_Per_Time(Method method) {
		homePage.refreshPage(driver);

		homePage.uploadMultipleFiles(driver, multipleFileNames);

		verifyTrue(homePage.isLoadedByFileName(dalatFileName));

		verifyTrue(homePage.isLoadedByFileName(hueFileName));

		verifyTrue(homePage.isLoadedByFileName(sapaFileName));

		homePage.clickToStartButton();

		verifyTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));

		verifyTrue(homePage.isUpLoadedLinkByFileName(hueFileName));

		verifyTrue(homePage.isUpLoadedLinkByFileName(sapaFileName));

		verifyTrue(homePage.isUpLoadedImageByFileName(dalatFileName));

		verifyTrue(homePage.isUpLoadedImageByFileName(hueFileName));

		verifyTrue(homePage.isUpLoadedImageByFileName(""));
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
	private homePageObject homePage;
}
