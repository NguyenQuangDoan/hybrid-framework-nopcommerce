package pageUIs.jQuery.dataTable;

public class adminDashBoardPageUI 	{
	public static final String MESSAGE_POPUP = "xpath=//div[@class='message-popup-head']";
	public static final String CLOSE_BUTTON_MESSAGE_POPUP = "xpath=//div[@class='message-popup-head']/a[@title='close']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th//a[@name='$s']/parent::span/parent::th/preceding-sibling::th";
	public static final String EMAIL_TEXTBOX_BY_COLUMN_INDEX = "xpath=//tr[%s]/th[%s]//input";
	public static final String SEARCH_BUTTON = "xpath=//button[@title='Search']";
	public static final String USER_NAME_AND_EMAIL = "xpath=//td[contains(text(), '%s')]/following-sibling::td[contains(text(), '%s')]";
	public static final String CHECKBOX_ACCOUNT_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//table[@id='customerGrid_table']//tbody/tr[%s]/td[%s]/input";
	public static final String SELECT_DELETE_OPTION = "css=#customerGrid_massaction-select";
	public static final String SUBMIT_BUTTON = "xpath=//button[@title='Submit']";
	public static final String NO_RESULT_ACCOUNT_FOUND = "xpath=//tbody/tr[%S]/td[text()='No records found.']";
	public static final String LOADING_MASK = "css=#loading-mask";
}
