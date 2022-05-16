package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String OVERLAY_SCREEN = "xpath=//div[@class='components-modal__screen-overlay']";
	public static final String CLOSE_BUTTON_OF_OVERLAY_SCREEN = "xpath=//div[@class='components-modal__screen-overlay']//button[@aria-label='Close dialog']";
	public static final String TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String BODY_BUTTON = "css=p[class*='block-editor-default']";
	public static final String BODY_TEXTBOX = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_BUTTON = "css=div[aria-label='Editor top bar'] button[class*='editor-post-publish-button']";
	public static final String PRE_PUBLISH_BUTTON = "css=div[aria-label='Editor publish'] button.editor-post-publish-button";
	public static final String PUBLISHED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
