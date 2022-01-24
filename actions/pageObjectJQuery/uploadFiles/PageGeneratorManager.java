package pageObjectJQuery.uploadFiles;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminDashBoardPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObjectJQuery.dataTable.adminDashboardPageObject;
import pageObjectJQuery.dataTable.adminLoginPageObject;
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
	
}
