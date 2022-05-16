package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCloseButtonOfOverlayScreen() {
		waitForElementVisible(driver, AdminPostAddNewPageUI.OVERLAY_SCREEN);
		waitForElementClickable(driver, AdminPostAddNewPageUI.CLOSE_BUTTON_OF_OVERLAY_SCREEN);
		clickToElement(driver, AdminPostAddNewPageUI.CLOSE_BUTTON_OF_OVERLAY_SCREEN);
	}

	public void enterToAddnewPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeysToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitle);
	}

	public void enterToAddnewBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeysToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBody);
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForAllElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
