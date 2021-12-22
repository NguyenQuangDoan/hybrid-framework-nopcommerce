package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class OrderPageObject extends BasePage {
	private HomePageUI homePageUI = new HomePageUI();
	private WebDriver driver;

	public OrderPageObject(WebDriver _driver) {
		driver = _driver;
	}

}
