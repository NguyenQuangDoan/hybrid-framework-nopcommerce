package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminDashBoardPageObject extends BasePage{
	WebDriver driver;
	
	public AdminDashBoardPageObject(WebDriver driver){
		this.driver = driver;
	}
}
