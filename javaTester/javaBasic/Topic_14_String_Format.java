package javaBasic;

public class Topic_14_String_Format {
	public static String REWARD_POINT_LINK = "//div[@class='side-2']//a[contains(text(), 'Reward')]";
	public static String CUSTOMER_INFO_LINK = "//div[@class='side-2']//a[contains(text(), 'Customer')]";
	public static String ORDERS_LINK = "//div[@class='side-2']//a[contains(text(), 'Orders')]";
	public static String ADDRESS_LINK = "//div[@class='side-2']//a[contains(text(), 'Address')]";

	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[@class='side-2']//a[contains(text(), '%s')]";
	
	public static void main(String[] agrs){
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Reward");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Customer");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Orders");
		clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "Address");
	}
	
	public static void clickToSideBarLink(String locator){
		System.out.println("Click to" + DYNAMIC_LINK_BY_PAGE_NAME);
	}
	
//	1 tham số động
//	public static void clickToSideBarLink(String dynamicLocator, String pageName){
//		String locator  = String.format(dynamicLocator, pageName);
//		System.out.println("Click to" + locator);
//	}
	
//	1->n tham số động
	public static void clickToSideBarLink(String dynamicLocator, String... params){
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to" + locator);
	}
}
