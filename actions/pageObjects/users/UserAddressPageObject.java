package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.UserHomePageUI;

public class UserAddressPageObject extends BasePage {
	private UserHomePageUI homePageUI = new UserHomePageUI();
	private WebDriver driver;

	public UserAddressPageObject(WebDriver _driver) {
		driver = _driver;
	}
}
