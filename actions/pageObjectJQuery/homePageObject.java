package pageObjectJQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
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
}
