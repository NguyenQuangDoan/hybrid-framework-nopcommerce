package pageObjects.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserCustomerInfoPageUI;
import pageUIs.UserHomePageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private UserHomePageUI homePageUI = new UserHomePageUI();
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public String getFirstNameText() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameText() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailAddressText() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
	}

	public UserHomePageObject clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
