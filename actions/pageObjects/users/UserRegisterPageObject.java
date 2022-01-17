package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {

	private UserRegisterPageUI registerPageUI = new UserRegisterPageUI();

	private WebDriver driver;

	public UserRegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerPageUI.REGISTER_BUTTON);
		clickToElement(driver, registerPageUI.REGISTER_BUTTON);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, registerPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, registerPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, registerPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, registerPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, registerPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, registerPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, registerPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, registerPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, registerPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, registerPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, registerPageUI.FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver, registerPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, registerPageUI.LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, registerPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, registerPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, registerPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, registerPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, registerPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, registerPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElement(driver, registerPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public String getRegisteredSuccessMessage() {
		waitForElementVisible(driver, registerPageUI.REGISTERED_SUCESS_MESSAGE);
		return getElementText(driver, registerPageUI.REGISTERED_SUCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, registerPageUI.LOGOUT_LINK);
		clickToElement(driver, registerPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getExistedEmailErrorMessage() {
		waitForElementVisible(driver, registerPageUI.EXISTED_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, registerPageUI.EXISTED_EMAIL_ERROR_MESSAGE);
	}


}
