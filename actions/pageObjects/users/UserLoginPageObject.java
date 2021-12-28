package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private UserLoginPageUI loginPageUI = new UserLoginPageUI();
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, loginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, loginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password){
		waitForElementClickable(driver, loginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, loginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, loginPageUI.LOGIN_BUTTON);
		clickToElement(driver, loginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserHomePageObject loginAsUser(String email, String password){
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
