package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class RewardPointPageObject extends BasePage {
	private HomePageUI homePageUI = new HomePageUI();
	private WebDriver driver;

	public RewardPointPageObject(WebDriver _driver) {
		driver = _driver;
	}

}
