package pageUIs.nopCommerce;

public class BasePageNopCommerceUI {
	public final static String REWARD_POINT_LINK = "xpath=//div[@class='side-2']//a[contains(text(), 'Reward')]";
	public final static String CUSTOMER_INFO_LINK = "xpath=//div[@class='side-2']//a[contains(text(), 'Customer')]";
	public final static String ORDERS_LINK = "xpath=//div[@class='side-2']//a[contains(text(), 'Orders')]";
	public final static String ADDRESS_LINK = "xpath=//div[@class='side-2']//a[contains(text(), 'Address')]";
	public final static String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[@class='side-2']//a[contains(text(), '%s')]";

	public final static String ADMIN_LOGOUT_LINK = "xpath=//div[@id='navbarText']//a[text()='Logout']";
	public final static String USER_LOGOUT_LINK = "xpath=//a[@class='ico-logout']";

	public final static String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public final static String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public final static String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public final static String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public final static String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";

}
