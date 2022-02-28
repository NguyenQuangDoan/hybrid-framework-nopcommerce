package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjectsJQuery.uploadFiles.PageGeneratorManager;
import pageObjectsJQuery.uploadFiles.homePageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentV2_Screenshot extends BaseTest {
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
		ExtentTestManager.startTest(method.getName(), "TC_01_Upload_Once_File_Per_Time");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Upload one per time - Step 01: Upload 'Da Lat' file");
		homePage.uploadMultipleFiles(driver, dalatFileName);

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 02: Verify 'Da Lat' file name is displayed");
		verifyTrue(homePage.isLoadedByFileName(dalatFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO, "Upload one per time - Step 03: Click to 'Start' button");
		homePage.clickToStartButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 04: Verify 'Da Lat' file link is ready");
		verifyTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 05: Verify 'Da Lat' image file is ready");
		verifyTrue(homePage.isUpLoadedImageByFileName(dalatFileName));
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Upload_Multiple_Files_Per_Time(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Upload_Multiple_Files_Per_Time");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Upload multiple files per time - Step 01: Refresh the page");
		homePage.refreshPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload multiple files per time - Step 02: Upload multiple files per time");
		homePage.uploadMultipleFiles(driver, multipleFileNames);

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload multiple files per time - Step 03: Verify 'Da Lat' file name is displayed");
		verifyTrue(homePage.isLoadedByFileName(dalatFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload multiple files per time - Step 04: Verify 'Hue' file name is displayed");
		verifyTrue(homePage.isLoadedByFileName(hueFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload multiple files per time - Step 05: Verify 'Sa Pa' file name is displayed");
		verifyTrue(homePage.isLoadedByFileName(sapaFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload multiple files per time - Step 06: Click to 'Start' button");
		homePage.clickToStartButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 07: Verify 'Da Lat' file link is ready");
		verifyTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 08: Verify 'Hue' file link is ready");
		verifyTrue(homePage.isUpLoadedLinkByFileName(hueFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 09: Verify 'Sa Pa' file link is ready");
		verifyTrue(homePage.isUpLoadedLinkByFileName(sapaFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 10: Verify 'Da Lat' image file is ready");
		verifyTrue(homePage.isUpLoadedImageByFileName(dalatFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 11: Verify 'Hue' image file is ready");
		verifyTrue(homePage.isUpLoadedImageByFileName(hueFileName));

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Upload one per time - Step 12: Verify 'Sa Pa' image file is ready");
		verifyTrue(homePage.isUpLoadedImageByFileName(""));
		ExtentTestManager.endTest();
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
