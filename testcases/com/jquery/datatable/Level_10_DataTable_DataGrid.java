package com.jquery.datatable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectJQuery.PageGeneratorManager;
import pageObjectJQuery.homePageObject;


public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	homePageObject homePage;



	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Paging() {
		homePage.openPagingPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActive("10"));
	}

	@Test
	public void TC_02_Enter_To_Header() {
		homePage.refreshPage(driver);
		
		homePage.enterToHeaderTextboxByLabel("Country", "Afghanistan");
		Assert.assertTrue(homePage.isDataFilterByTotalHeader("791312"));
		homePage.sleepInSecond(3);
	}
	
	@Test
	public void TC_03_TC_02_Enter_To_Header(){
		homePage.refreshPage(driver);
		homePage.getRowValueAtAllPage();
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	
}
