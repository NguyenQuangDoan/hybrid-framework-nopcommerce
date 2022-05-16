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

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	String adminUsername = "quangdoan";
	String adminPassword = "quangdoan";
	String searchPostUrl;
	String postTitle = "Live Coding Title " + generateFakeNumber(),
			postBody = "Live Coding Body " + generateFakeNumber(), authorName = "QuangDoan";
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
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create_Post - Step 07: Click to 'Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Create_Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
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

	}

	@Test
	public void Post_04_Delete_Post() {

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
}
