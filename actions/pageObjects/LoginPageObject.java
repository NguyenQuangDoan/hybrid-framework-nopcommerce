package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private LoginPageUI loginPageUI = new LoginPageUI();
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
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
	
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, loginPageUI.LOGIN_BUTTON);
		clickToElement(driver, loginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
