package pageUIs.jQuery.dataTable;

public class homePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABELNAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_NUMBER_FILTER_BY_LABELNAME = "xpath=//tbody/tr/td[text()='%s']";
	public static final String TOTAL_PAGGINATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	
	public static final String LOAD_BUTTON = "xpath= //button[@id='btnLoad']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String ICON_NAME_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]//button[@title='%s']";
	
	public static final String MY_ACCOUNT_LINK = "xpath=//div[@class='footer']//a[@title='My Account']";
	public static final String CREATE_AN_ACCOUNT_BUTTON = "xpath=//a[@title='Create an Account']";
	public static final String FIRST_NAME_TEXTBOX = "css=input#firstname";
	public static final String LAST_NAME_TEXTBOX = "css=input#lastname";
	public static final String EMAIL_TEXTBOX = "css=input#email_address";
	public static final String PASSWORD_TEXTBOX = "css=input#password";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "css=input#confirmation";
	public static final String REGISTER_BUTTON = "xpath=//button[@title='Register']";
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']";
	
	public static final String USER_NAME_INPUT = "css=#email";
	public static final String PASSWORD_INPUT = "css=#pass";
	public static final String LOGIN_BUTTON = "xpath=//button[@title='Login']";
	public static final String ERROR_MESSAGE = "xpath=//li[@class='error-msg']";
}
