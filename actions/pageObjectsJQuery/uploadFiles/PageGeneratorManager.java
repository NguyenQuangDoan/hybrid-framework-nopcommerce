package pageObjectsJQuery.uploadFiles;

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
import pageObjectsJQuery.dataTable.adminDashboardPageObject;
import pageObjectsJQuery.dataTable.adminLoginPageObject;

public class PageGeneratorManager {
	public static homePageObject getHomePage(WebDriver driver){
		return new homePageObject(driver);
	}
	
}
