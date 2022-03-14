package pageObjectsJQuery.dataTable;

import org.openqa.selenium.WebDriver;

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
