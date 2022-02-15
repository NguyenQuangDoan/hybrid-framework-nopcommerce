package pageObjectsJQuery.dataTable;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashBoardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.UserAddressPageObject;
import pageObjects.users.UserCustomerInfoPageObject;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserOrderPageObject;
import pageObjects.users.UserRegisterPageObject;
import pageObjects.users.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static homePageObject getHomePage(WebDriver driver){
		return new homePageObject(driver);
	}
	
	public static adminLoginPageObject getAdminLoginPage(WebDriver driver){
		return new adminLoginPageObject(driver);
	}
	
	public static adminDashboardPageObject getAdminDashboardPage(WebDriver driver){
		return new adminDashboardPageObject(driver);
	}
	
}
