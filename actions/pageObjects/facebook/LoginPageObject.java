package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.register.loginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, loginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, loginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, loginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, loginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, loginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, loginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, loginPageUI.CONFIRMATION_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickToCloseIconAtRegisterForm() {
		waitForElementClickable(driver, loginPageUI.CLOSE_ICON);
		clickToElement(driver, loginPageUI.CLOSE_ICON);
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		// TODO Auto-generated method stub
		return isElementUndisplayed(driver, loginPageUI.CONFIRMATION_EMAIL_ADDRESS_TEXTBOX);
	}
}
