package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private UserHomePageUI homePageUI = new UserHomePageUI();
	private WebDriver driver;

	public UserHomePageObject(WebDriver _driver) {
		driver = _driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, homePageUI.REGISTER_LINK);
		clickToElement(driver, homePageUI.REGISTER_LINK);
		return new UserRegisterPageObject(driver);
	}
	
	
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, homePageUI.LOGIN_LINK);
		clickToElement(driver, homePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink(){
		waitForElementClickable(driver, homePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, homePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
}
