package pageObjectsJQuery.uploadFiles;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static homePageObject getHomePage(WebDriver driver){
		return new homePageObject(driver);
	}
	
}
