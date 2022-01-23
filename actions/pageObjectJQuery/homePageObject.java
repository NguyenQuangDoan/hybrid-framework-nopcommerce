package pageObjectJQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.adminLoginPageUI;
import pageUIs.jQuery.homePageUI;

public class homePageObject extends BasePage{
	WebDriver driver;
	
	public homePageObject(WebDriver driver){
		this.driver = driver;
	}

	public void openPagingPageNumber(String pageNumber) {
		waitForElementClickable(driver, homePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, homePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, homePageUI.HEADER_TEXTBOX_BY_LABELNAME, headerLabel);
		sendkeysToElement(driver, homePageUI.HEADER_TEXTBOX_BY_LABELNAME, value, headerLabel);
		pressKeyboardToElement(driver, homePageUI.HEADER_TEXTBOX_BY_LABELNAME, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, homePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, homePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	
	public boolean isDataFilterByTotalHeader(String totalNumber) {
		waitForElementVisible(driver, homePageUI.TOTAL_NUMBER_FILTER_BY_LABELNAME, totalNumber);
		return isElementDisplayed(driver, homePageUI.TOTAL_NUMBER_FILTER_BY_LABELNAME, totalNumber);
	}

	public List <String> getRowValueAtAllPage() {
		int totalPage = getElementSize(driver, homePageUI.TOTAL_PAGGINATION);
		System.out.println(totalPage);
		
		List <String> allRowValuesAllPage = new ArrayList<String>();
		for (int index = 1; index < totalPage; index++) {
			clickToElement(driver, homePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
			
			
			List <WebElement> allRowElementEachPage = getWebElements(driver, homePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		
		for (String value: allRowValuesAllPage) {
			System.out.println(value);
		}
		
		return allRowValuesAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToEnter) {
		int columnIndex = getElementSize(driver, homePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(driver, homePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeysToElement(driver, homePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, homePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, homePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, homePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, homePageUI.LOAD_BUTTON);
		clickToElement(driver, homePageUI.LOAD_BUTTON);
	}

	public void checkToCheckboxByColumNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, homePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, homePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToRadioOrCheckbox(driver, homePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, homePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, homePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToCheckbox(driver, homePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, homePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver,  homePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, homePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, homePageUI.MY_ACCOUNT_LINK);
	}

	public void clickToCreateAnAccountButton() {
		waitForElementClickable(driver, homePageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, homePageUI.CREATE_AN_ACCOUNT_BUTTON);
	}

	public void fillFirstNameToTextbox(String firstName) {
		waitForElementVisible(driver, homePageUI.FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver, homePageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void fillLastNameToTextbox(String lastName) {
		waitForElementVisible(driver, homePageUI.LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, homePageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void fillEmailToTextbox(String userEmail) {
		waitForElementVisible(driver, homePageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, homePageUI.EMAIL_TEXTBOX, userEmail);
	}

	public void fillPasswordToTextbox(String password) {
		waitForElementVisible(driver, homePageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, homePageUI.PASSWORD_TEXTBOX, password);
	}

	public void fillComfirmPasswordToTextbox(String password) {
		waitForElementVisible(driver, homePageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElement(driver, homePageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, homePageUI.REGISTER_BUTTON);
		clickToElement(driver, homePageUI.REGISTER_BUTTON);
	}

	public String getRegisteredSuccessMessage() {
		waitForElementVisible(driver, homePageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, homePageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
//	
	public void inputToEmailTextbox(String userEmailAddress){
		waitForElementVisible(driver, homePageUI.USER_NAME_INPUT);
		sendkeysToElement(driver, homePageUI.USER_NAME_INPUT, userEmailAddress);
	}
	
	public void inputToPasswordTextbox(String userPassword){
		waitForElementVisible(driver, homePageUI.PASSWORD_INPUT);
		sendkeysToElement(driver, homePageUI.PASSWORD_INPUT, userPassword);
	}
	
	public homePageObject clickToLoginButton(){
		waitForElementClickable(driver, homePageUI.LOGIN_BUTTON);
		clickToElement(driver, homePageUI.LOGIN_BUTTON);
		areJQueryAndJSLoadedSuccess(driver);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public homePageObject loginAsUser(String userEmailAddress, String userPassword){
		inputToEmailTextbox(userEmailAddress);
		inputToPasswordTextbox(userPassword);
		return clickToLoginButton();
	}

	public String getNoResultForAccount() {
		waitForElementVisible(driver, homePageUI.ERROR_MESSAGE);
		return getElementText(driver, homePageUI.ERROR_MESSAGE);
	}

	
}
