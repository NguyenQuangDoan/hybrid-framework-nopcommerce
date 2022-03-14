package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsJQuery.uploadFiles.PageGeneratorManager;
import pageObjectsJQuery.uploadFiles.homePageObject;

public class Level_14_Log_ReportNG extends BaseTest {
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
	public void TC_01_Upload_Once_File_Per_Time() {
//		log.info("Upload one per time - Step 01: Upload 'Da Lat' file");
//		homePage.uploadMultipleFiles(driver, dalatFileName);
//
//		log.info("Upload one per time - Step 02: Verify 'Da Lat' file name is displayed");
//		verifyTrue(homePage.isLoadedByFileName(dalatFileName));
//
//		log.info("Upload one per time - Step 03: Click to 'Start' button");
//		homePage.clickToStartButton();
//
//		log.info("Upload one per time - Step 04: Verify 'Da Lat' file link is ready");
//		verifyTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));
//
//		log.info("Upload one per time - Step 05: Verify 'Da Lat' image file is ready");
//		verifyTrue(homePage.isUpLoadedImageByFileName(dalatFileName));
	}

	@Test
	public void TC_02_Upload_Multiple_Files_Per_Time() {
//		log.info("Upload multiple files per time - Step 01: Refresh the page");
//		homePage.refreshPage(driver);
//
//		log.info("Upload multiple files per time - Step 02: Upload multiple files per time");
//		homePage.uploadMultipleFiles(driver, multipleFileNames);
//
//		log.info("Upload multiple files per time - Step 03: Verify 'Da Lat' file name is displayed");
//		verifyTrue(homePage.isLoadedByFileName(dalatFileName));
//
//		log.info("Upload multiple files per time - Step 04: Verify 'Hue' file name is displayed");
//		verifyTrue(homePage.isLoadedByFileName(hueFileName));
//
//		log.info("Upload multiple files per time - Step 05: Verify 'Sa Pa' file name is displayed");
//		verifyTrue(homePage.isLoadedByFileName(sapaFileName));
//
//		log.info("Upload multiple files per time - Step 06: Click to 'Start' button");
//		homePage.clickToStartButton();
//
//		log.info("Upload one per time - Step 07: Verify 'Da Lat' file link is ready");
//		verifyTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));
//
//		log.info("Upload one per time - Step 08: Verify 'Hue' file link is ready");
//		verifyTrue(homePage.isUpLoadedLinkByFileName(hueFileName));
//
//		log.info("Upload one per time - Step 09: Verify 'Sa Pa' file link is ready");
//		verifyTrue(homePage.isUpLoadedLinkByFileName(sapaFileName));
//
//		log.info("Upload one per time - Step 10: Verify 'Da Lat' image file is ready");
//		verifyTrue(homePage.isUpLoadedImageByFileName(dalatFileName));
//
//		log.info("Upload one per time - Step 11: Verify 'Hue' image file is ready");
//		verifyTrue(homePage.isUpLoadedImageByFileName(hueFileName));
//
//		log.info("Upload one per time - Step 12: Verify 'Sa Pa' image file is ready");
//		verifyTrue(homePage.isUpLoadedImageByFileName(sapaFileName));
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
