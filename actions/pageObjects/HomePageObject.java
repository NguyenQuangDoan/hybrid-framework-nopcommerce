package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private HomePageUI homePageUI = new HomePageUI();
	private WebDriver driver;

	public HomePageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, homePageUI.REGISTER_LINK);
		clickToElement(driver, homePageUI.REGISTER_LINK);
	}

}
