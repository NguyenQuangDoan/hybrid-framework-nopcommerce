package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName, String urlName){
		
		browserList browser = browserList.valueOf(browserName.toUpperCase());
		
		if (browser == browserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser == browserList.CHROME){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser == browserList.EDGE){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("This browser is not supported");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlName);
		driver.manage().window().maximize();
		return driver;
	}
}
