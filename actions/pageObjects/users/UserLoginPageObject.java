package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private UserLoginPageUI loginPageUI = new UserLoginPageUI();
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password){
		waitForElementClickable(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserHomePageObject loginAsUser(String email, String password){
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
