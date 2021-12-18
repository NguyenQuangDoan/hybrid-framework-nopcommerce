package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;
import pageUIs.HomePageUI;

public class CustomerInfoPageObject extends BasePage {
	private HomePageUI homePageUI = new HomePageUI();
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public String getFirstNameText() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameText() {
		waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailAddressText() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
	}

	public HomePageObject clickToSaveButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
