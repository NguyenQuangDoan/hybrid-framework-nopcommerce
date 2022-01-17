package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.UserHomePageUI;

public class UserRewardPointPageObject extends BasePage {
	private UserHomePageUI homePageUI = new UserHomePageUI();
	private WebDriver driver;

	public UserRewardPointPageObject(WebDriver _driver) {
		driver = _driver;
	}

}
