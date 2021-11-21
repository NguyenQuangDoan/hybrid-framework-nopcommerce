package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_Login {WebDriver driver;
String projectPath = System.getProperty("user.dir");

@BeforeClass
public void beforeClass() {
	// Firefox
	System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
//	something wrong
	
	// Chrome
//	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//	driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://demo.nopcommerce.com/");
}

@Test
public void TC_01_ValidateCurrentUrl() {}

@Test
public void TC_02_ValidatePageTitle() {}

@Test
public void TC_03_LoginFormDisplayed() {}

@AfterClass
public void afterClass() {
	driver.quit();
}}
