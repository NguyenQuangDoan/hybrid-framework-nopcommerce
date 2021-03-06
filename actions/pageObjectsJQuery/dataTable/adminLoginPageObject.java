package pageObjectsJQuery.dataTable;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.jQuery.dataTable.adminLoginPageUI;


public class adminLoginPageObject extends BasePage{
	WebDriver driver;
	
	public adminLoginPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String adminEmailAddress){
		waitForElementVisible(driver, adminLoginPageUI.USER_NAME_INPUT);
		sendkeysToElement(driver, adminLoginPageUI.USER_NAME_INPUT, adminEmailAddress);
	}
	
	public void inputToPasswordTextbox(String adminPassword){
		waitForElementVisible(driver, adminLoginPageUI.PASSWORD_INPUT);
		sendkeysToElement(driver, adminLoginPageUI.PASSWORD_INPUT, adminPassword);
	}
	
	public adminDashboardPageObject clickToLoginButton(){
		waitForElementClickable(driver, adminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, adminLoginPageUI.LOGIN_BUTTON);
		areJQueryAndJSLoadedSuccess(driver);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public adminDashboardPageObject loginAsAdmin(String adminEmailAddress, String adminPassword){
		inputToEmailTextbox(adminEmailAddress);
		inputToPasswordTextbox(adminPassword);
		return clickToLoginButton();
	}
	
}
