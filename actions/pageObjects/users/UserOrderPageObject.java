package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.UserHomePageUI;

public class UserOrderPageObject extends BasePage {
	private UserHomePageUI homePageUI = new UserHomePageUI();
	private WebDriver driver;

	public UserOrderPageObject(WebDriver _driver) {
		driver = _driver;
	}

}
