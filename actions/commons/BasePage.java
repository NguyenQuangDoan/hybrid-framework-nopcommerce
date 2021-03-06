package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.UserHomePO;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.UserAddressPageObject;
import pageObjects.users.UserCustomerInfoPageObject;
import pageObjects.users.UserHomePageObject;
import pageObjects.users.UserOrderPageObject;
import pageObjects.users.UserRewardPointPageObject;
import pageUIs.jQuery.uploadFiles.BasePageJQueryUI;
import pageUIs.nopCommerce.BasePageNopCommerceUI;

/**
 * @author Admin
 *
 */
public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void senkeysToAlert(WebDriver driver, String value) {
		waitForAlertPresence(driver).sendKeys(value);
	}

	public void switchToWindowByID(WebDriver driver, String windowPageID) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(windowPageID)) {
				driver.switchTo().window(window);
			}
		}
	}

	public void switchToWindowByPageTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			driver.switchTo().window(window);
			sleepInSecond(2);

			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentPageID) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(parentPageID)) {
				driver.switchTo().window(window);
				sleepInSecond(1);
				driver.close();
			}
		}
		driver.switchTo().window(parentPageID);
		sleepInSecond(2);
	}

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleepInMilisecond(long timeoutInMilisecond) {
		try {
			Thread.sleep(timeoutInMilisecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")
				|| locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getWebElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeysToElement(WebDriver driver, String locatorType, String value) {
		getWebElement(driver, locatorType).clear();
		getWebElement(driver, locatorType).sendKeys(value);
	}

	public void clearValueInElementByDeleteKey(WebDriver driver, String locatorType) {
		WebElement element = this.getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	public void sendkeysToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).clear();
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String itemText) {
		new Select(getWebElement(driver, locatorType)).selectByVisibleText(itemText);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String itemText,
			String... dynamicValues) {
		new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).selectByVisibleText(itemText);
	}

	public String getSelectTextInDefaultDropdown(WebDriver driver, String locatorType) {
		return new Select(getWebElement(driver, locatorType)).getFirstSelectedOption().getText();
	}

	public boolean isDefaultDropdownMultiple(WebDriver driver, String locatorType) {
		return new Select(getWebElement(driver, locatorType)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType)).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return driver.findElement(getByLocator(getDynamicXpath(locatorType, dynamicValues))).getText();
	}

	public String getAttributeValue(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getAttributeValue(WebDriver driver, String locatorType, String attributeName,
			String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	public String getCssValue(WebDriver driver, String locatorType, String cssValueName) {
		return getWebElement(driver, locatorType).getCssValue(cssValueName);
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getWebElements(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElements(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public String getHexaColorByRgbaColor(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex();
	}

	public int getElementsNumber(WebDriver driver, String locatorType) {
		return getWebElements(driver, locatorType).size();
	}

	public void checkToRadioOrCheckbox(WebDriver driver, String locatorType) {
		if (!getWebElement(driver, locatorType).isSelected()) {
			getWebElement(driver, locatorType).click();
		}
	}

	public void checkToRadioOrCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		if (!getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected()) {
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locatorType) {
		if (getWebElement(driver, locatorType).isSelected()) {
			getWebElement(driver, locatorType).click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		if (getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected()) {
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, ShortTimeOut);
		List<WebElement> elements = getWebElements(driver, locator);
		overrideGlobalTimeout(driver, longTimeout);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator, String... dynamicValues) {
		overrideGlobalTimeout(driver, ShortTimeOut);
		List<WebElement> elements = getWebElements(driver, getDynamicXpath(locator, dynamicValues));
		overrideGlobalTimeout(driver, longTimeout);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public void switchToFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContentPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void pressKeyboardToElement(WebDriver driver, String locatorType, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyboardToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		new Actions(driver).sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void highlightElement(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locatorType, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions
				.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	/*
	 * Wait for element undisplayed in DOM or not in DOM and override implicit
	 * timeout
	 */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitwait = new WebDriverWait(driver, ShortTimeOut);
		overrideGlobalTimeout(driver, ShortTimeOut);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideGlobalTimeout(driver, LongTimeOut);
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, locatorType)));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalContants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
		System.out.println(fullFileName);
	}

	private long longTimeout = GlobalContants.LONG_TIMEOUT;

	public UserOrderPageObject openOrderPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.ORDERS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ORDERS_LINK);
		return PageGeneratorManager.getUserOrderPage(driver);
	}

	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageNopCommerceUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageNopCommerceUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public BasePage openPagesAtMyAccountPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);

		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		case "Reward point":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case "Order":
			return PageGeneratorManager.getUserOrderPage(driver);
		case "Address":
			return PageGeneratorManager.getUserAddressPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account area");
		}
	}

	// Pattern Object
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
	}

	/**
	 * Enter to dynamic textbox by ID
	 * 
	 * @author Doan Nguyen
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForAllElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeysToElement(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	/**
	 * Click to button by Text
	 * 
	 * @author Doan Nguyen
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	/**
	 * Select item in dropdown by name attribute
	 * 
	 * @author Doan Nguyen
	 * @param driver
	 * @param dropdownAttributeName
	 * @param itemValue
	 */
	public void selectToDropDownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue,
				dropdownAttributeName);
	}

	/**
	 * Click to dynamic radio button by label
	 * 
	 * @author Doan Nguyen
	 * @param driver
	 * @param radioButtonLabelName
	 */
	public void clickToRadioButtonByLabel(WebDriver driver, String radioButtonLabelName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
		checkToRadioOrCheckbox(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
	}

	/**
	 * Click to dynamic checkbox by label
	 * 
	 * @author Doan Nguyen
	 * @param driver
	 * @param checkboxLabelName
	 */
	public void clickToCheckboxByLabel(WebDriver driver, String checkboxLabelName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
		checkToRadioOrCheckbox(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
	}

	/**
	 * Get dynamic textbox value by ID
	 * 
	 * @author Doan Nguyen
	 * @param driver
	 * @param textboxValue
	 */
	public String getTextboxValueByID(WebDriver driver, String textboxID) {
		waitForAllElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getAttributeValue(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	// Level_08_Switch_Role
	public AdminLoginPageObject clickToAdminLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.ADMIN_LOGOUT_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public UserHomePO openEndUserSite(WebDriver driver, String urlEndUser) {
		openUrl(driver, urlEndUser);
		return pageObject.wordpress.PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminDashboardPO openAdminSite(WebDriver driver, String urlAdmin) {
		openUrl(driver, urlAdmin);
		return pageObject.wordpress.PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public UserHomePageObject clickToUserLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.USER_LOGOUT_LINK);
		clickToElement(driver, BasePageNopCommerceUI.USER_LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	private long LongTimeOut = GlobalContants.LONG_TIMEOUT;
	private long ShortTimeOut = GlobalContants.SHORT_TIMEOUT;

}
