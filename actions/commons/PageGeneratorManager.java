package commons;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminDashBoardPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObjects.users.UserAddressPageObject;
import pageObjects.users.UserCustomerInfoPageObject;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserOrderPageObject;
import pageObjects.users.UserRegisterPageObject;
import pageObjects.users.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver){
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getUserLoginPage(WebDriver driver){
		return new UserLoginPageObject(driver);
	}
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
		return new UserRegisterPageObject(driver);
	}
	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver){
		return new UserCustomerInfoPageObject(driver);
	}
	
	public static UserOrderPageObject getUserOrderPage(WebDriver driver){
		return new UserOrderPageObject(driver);
	}
	
	public static UserAddressPageObject getUserAddressPage(WebDriver driver){
		return new UserAddressPageObject(driver);
	}
	
	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver){
		return new UserRewardPointPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver){
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashBoardPageObject getAdminDashBoardPage(WebDriver driver){
		return new AdminDashBoardPageObject(driver);
	}
}
