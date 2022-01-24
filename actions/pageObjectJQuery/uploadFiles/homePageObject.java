package pageObjectJQuery.uploadFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFiles.homePageUI;

public class homePageObject extends BasePage {
	WebDriver driver;

	public homePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLoadedByFileName(String fileName) {
		waitForElementVisible(driver, homePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, homePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtonNumbers = getWebElements(driver, homePageUI.START_BUTTON);

		for (WebElement startButton : startButtonNumbers) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isUpLoadedLinkByFileName(String fileName) {
		waitForElementVisible(driver, homePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, homePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public boolean isUpLoadedImageByFileName(String fileName) {
		waitForElementVisible(driver, homePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, homePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

}
