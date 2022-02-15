package com.jquery;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsJQuery.uploadFiles.PageGeneratorManager;
import pageObjectsJQuery.uploadFiles.homePageObject;

public class Level_11_Uplioad_Files extends BaseTest {
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
		homePage.uploadMultipleFiles(driver, dalatFileName);

		Assert.assertTrue(homePage.isLoadedByFileName(dalatFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));
		Assert.assertTrue(homePage.isUpLoadedImageByFileName(dalatFileName));
	}

	@Test
	public void TC_02_Upload_Multiple_Files_Per_Time() {
		homePage.refreshPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);

		Assert.assertTrue(homePage.isLoadedByFileName(dalatFileName));
		Assert.assertTrue(homePage.isLoadedByFileName(hueFileName));
		Assert.assertTrue(homePage.isLoadedByFileName(sapaFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isUpLoadedLinkByFileName(dalatFileName));
		Assert.assertTrue(homePage.isUpLoadedLinkByFileName(hueFileName));
		Assert.assertTrue(homePage.isUpLoadedLinkByFileName(sapaFileName));

		Assert.assertTrue(homePage.isUpLoadedImageByFileName(dalatFileName));
		Assert.assertTrue(homePage.isUpLoadedImageByFileName(hueFileName));
		Assert.assertTrue(homePage.isUpLoadedImageByFileName(sapaFileName));
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
