package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String emailAddress){
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void inputToPasswordTextbox(String password){
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD);
		sendkeysToElement(driver, AdminLoginPageUI.PASSWORD, password);
	}
	
	public AdminDashBoardPageObject clickToLoginButton(){
		waitForElementClickable(driver, AdminLoginPageUI.PASSWORD);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		areJQueryAndJSLoadedSuccess(driver);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
	
	public AdminDashBoardPageObject loginAsAdmin(String emailAddress, String password){
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
