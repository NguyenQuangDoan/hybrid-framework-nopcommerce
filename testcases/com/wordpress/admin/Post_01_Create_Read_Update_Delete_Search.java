package com.wordpress.admin;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserSearchPostPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	String adminUsername = "quangdoan";
	String adminPassword = "quangdoan";
	String searchPostUrl;
	String postTitle = "Live Coding Title " + generateFakeNumber(),
			postBody = "Live Coding Body " + generateFakeNumber(), authorName = "QuangDoan";
	String editPostTitle = "Edit Title " + generateFakeNumber();
	String editPostBody = "Edit Body " + generateFakeNumber();
	String urlAdmin, urlEndUser;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlEndUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlEndUser) {
		log.info("Pre-condition - Step 01: Open browser and admin site");
		this.urlAdmin = urlAdmin;
		this.urlEndUser = urlEndUser;
		driver = getBrowserDriver(browserName, this.urlAdmin);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Enter to username textbox with value:" + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-condition - Step 03: Enter to password textbox with value:" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-condition - Step 04: Click on 'Log In' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click on 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Create_Post - Step 02: Get 'Search Posts' page url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create_Post - Step 03: Click on 'Add new' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create Post - Step 04: Close the overlay screen");
		adminPostAddNewPage.clickToCloseButtonOfOverlayScreen();

		log.info("Create_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddnewPostTitle(postTitle);

		log.info("Create_Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToAddnewBody(postBody);

		log.info("Create_Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Create_Post - Step 07: Click to 'Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Create_Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishOrUpdateMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search_Post - Step 03: Click to Search Posts button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Search_Post - Step 04: Verify  Search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDetailDisplayed("title", postTitle));

		log.info("Search_Post - Step 05: Verify  Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDetailDisplayed("author", authorName));

		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.urlEndUser);

		log.info("Search_Post - Step 07: Verify Post info displayed at Home page");
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithAuthorName(postTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithCurrentDay(postTitle, currentDay));

		log.info("Search_Post - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search_Post - Step 09: Verify Post info displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithAuthorName(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithCurrentDay(postTitle, currentDay));
	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.urlAdmin);

		log.info("Edit_Post - Step 02: Click on 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Edit_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Edit_Post - Step 04: Click to Search Posts button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Edit_Post - Step 05: Click to Post title link and navigate to Edit Post page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit_Post - Step 06: Enter to post title");
		adminPostAddNewPage.enterToAddnewPostTitle(editPostTitle);

		log.info("Edit_Post - Step 07: Enter to body");
		adminPostAddNewPage.enterToEditPostBody(editPostBody);

		log.info("Edit_Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Edit_Post - Step 09: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishOrUpdateMessageDisplayed("Post updated."));

		log.info("Edit_Post - Step 10: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Edit_Post - Step 11: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Edit_Post - Step 12: Click to Search Posts button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Edit_Post - Step 13: Verify  Search table contains '" + editPostTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDetailDisplayed("title", editPostTitle));

		log.info("Edit_Post - Step 14: Verify  Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDetailDisplayed("author", authorName));

		log.info("Edit_Post - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.urlEndUser);

		log.info("Edit_Post - Step 16: Verify Post info displayed at Home page");
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithAuthorName(editPostTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithCurrentDay(editPostTitle, currentDay));

		log.info("Edit_Post - Step 17: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);

		log.info("Edit_Post - Step 18: Verify Post info displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithAuthorName(editPostTitle, authorName));
		verifyTrue(userPostDetailPage.isPostDetailInfoDisplayedWithCurrentDay(editPostTitle, currentDay));
	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.urlAdmin);

		log.info("Delete_Post - Step 02: Click on 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Delete_Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 04: Click to Search Posts button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Delete_Post - Step 05: Select Post detail checkbox");
		adminPostSearchPage.selectCheckboxByTitle(editPostTitle);

		log.info("Delete_Post - Step 06: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");

		log.info("Delete_Post - Step 07: Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();

		log.info("Delete_Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));

		log.info("Delete_Post - Step 09: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 10: Click to Search Posts button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Delete_Post - Step 11: Verify 'No posts found.' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));

		log.info("Delete_Post - Step 12: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.urlEndUser);

		log.info("Delete_Post - Step 13: Verify Post title undisplayed at Home page");
		verifyTrue(userHomePage.isPostInfoUndisplayedWithPostTitle(editPostTitle));

		log.info("Delete_Post - Step 14: Enter to Search textbox");
		userHomePage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 15: Click to Search Posts button");
		userSearchPostPage = userHomePage.clickToSearchButton();

		log.info("Delete_Post - Step 16: Verify 'Nothing Found' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;
}
