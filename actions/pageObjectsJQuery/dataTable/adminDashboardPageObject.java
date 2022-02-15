package pageObjectsJQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.adminDashBoardPageUI;
import pageUIs.jQuery.dataTable.homePageUI;

public class adminDashboardPageObject extends BasePage{
	WebDriver driver;
	
	public adminDashboardPageObject(WebDriver driver){
		this.driver = driver;
	}

	public void closeThePopupMessage() {
		waitForElementVisible(driver, adminDashBoardPageUI.MESSAGE_POPUP);
		waitForElementClickable(driver, adminDashBoardPageUI.CLOSE_BUTTON_MESSAGE_POPUP);
		clickToElement(driver, adminDashBoardPageUI.CLOSE_BUTTON_MESSAGE_POPUP);
	}

	public void enterToTextboxByColumnNameAtColumnNumber(String columnName, String columnNumber, String userEmail) {
		int columnIndex = getElementSize(driver, adminDashBoardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 2;
		System.out.println(columnIndex);
		waitForElementVisible(driver, adminDashBoardPageUI.EMAIL_TEXTBOX_BY_COLUMN_INDEX,String.valueOf(columnIndex), columnNumber);
		sendkeysToElement(driver, adminDashBoardPageUI.EMAIL_TEXTBOX_BY_COLUMN_INDEX, userEmail, String.valueOf(columnIndex),columnNumber);
	}

	public void clickSearchButton() {
		waitForElementClickable(driver, adminDashBoardPageUI.SEARCH_BUTTON);
		clickToElement(driver, adminDashBoardPageUI.SEARCH_BUTTON);
	}


	public boolean userInfoIsDisplayed(String userName, String userEmail) {
		waitForElementVisible(driver, adminDashBoardPageUI.USER_NAME_AND_EMAIL, userName, userEmail);
		return isElementDisplayed(driver, adminDashBoardPageUI.USER_NAME_AND_EMAIL, userName, userEmail);
	}

	public void clickCheckboxAccount(String rowIndex, String columnIndex) {
		waitForElementInvisible(driver, adminDashBoardPageUI.LOADING_MASK);
		waitForElementClickable(driver, adminDashBoardPageUI.CHECKBOX_ACCOUNT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowIndex, columnIndex);
		checkToRadioOrCheckbox(driver, adminDashBoardPageUI.CHECKBOX_ACCOUNT_BY_COLUMN_INDEX_AND_ROW_INDEX, rowIndex, columnIndex);
	}

	public void selectDeleteOption(String valueToSelect) {
		waitForElementClickable(driver, adminDashBoardPageUI.SELECT_DELETE_OPTION);
		selectItemInDefaultDropdown(driver, adminDashBoardPageUI.SELECT_DELETE_OPTION, valueToSelect);
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, adminDashBoardPageUI.SUBMIT_BUTTON);
		clickToElement(driver,  adminDashBoardPageUI.SUBMIT_BUTTON);
	}

	public void acceptAlertPopup() {
		acceptAlert(driver);
	}

	public String getNoResultSearching(String rowIndex) {
		waitForElementVisible(driver, adminDashBoardPageUI.NO_RESULT_ACCOUNT_FOUND, rowIndex);
		return getElementText(driver, adminDashBoardPageUI.NO_RESULT_ACCOUNT_FOUND, rowIndex);
	}

	
}
