package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "register-button")
	private WebElement registerButton;

	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;

	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;

	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;

	@FindBy(id = "Password-error")
	private WebElement passwordErrorMessage;

	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(xpath = "//div[contains(@class, 'message-error')]//li")
	private WebElement existedEmailErrorMessage;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registeredSuccessMessage;

	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;

	@CacheLookup
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;

	@CacheLookup
	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@CacheLookup
	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@CacheLookup
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;

	@CacheLookup
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logOutLink;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(firstNameErrorMessage);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(lastNameErrorMessage);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(emailErrorMessage);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(passwordErrorMessage);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(confirmPasswordErrorMessage);
	}

	public void sendkeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeysToElement(driver, firstNameTextbox, firstName);
	}

	public void sendkeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeysToElement(driver, lastNameTextbox, lastName);
	}

	public void sendkeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeysToElement(driver, emailTextbox, emailAddress);
	}

	public void sendkeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeysToElement(driver, passwordTextbox, password);
	}

	public void sendkeysToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeysToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisteredSuccessMessage() {
		waitForElementVisible(driver, registeredSuccessMessage);
		return getElementText(registeredSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logOutLink);
		clickToElement(driver, logOutLink);
	}

	public String getExistedEmailErrorMessage() {
		waitForElementVisible(driver, existedEmailErrorMessage);
		return getElementText(existedEmailErrorMessage);
	}
}
