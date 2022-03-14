package pageObjectsJQuery.uploadFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.jQuery.uploadFiles.homePageUI;

public class homePageObject extends BasePage {
	WebDriver driver;

	public homePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify 'File name' displayed")
	public boolean isLoadedByFileName(String fileName) {
		waitForElementVisible(driver, homePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, homePageUI.FILE_NAME_LOADED, fileName);
	}

	@Step("Click on 'Start' button")
	public void clickToStartButton() {
		List<WebElement> startButtonNumbers = getWebElements(driver, homePageUI.START_BUTTON);

		for (WebElement startButton : startButtonNumbers) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	@Step("Verify 'File name' link to displayed")
	public boolean isUpLoadedLinkByFileName(String fileName) {
		waitForElementVisible(driver, homePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, homePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	@Step("Verify 'File name' image to displayed")
	public boolean isUpLoadedImageByFileName(String fileName) {
		waitForElementVisible(driver, homePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, homePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

}
