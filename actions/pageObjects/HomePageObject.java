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

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, homePageUI.REGISTER_LINK);
		clickToElement(driver, homePageUI.REGISTER_LINK);
		return new RegisterPageObject(driver);
	}
	
	
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, homePageUI.LOGIN_LINK);
		clickToElement(driver, homePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public CustomerInfoPageObject clickToMyAccountLink(){
		waitForElementClickable(driver, homePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, homePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}
}
