package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LogInModal;
import com.qaprosoft.carina.demo.gui.emuns.FooterMenuButtons;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.projectConstants.ProjectConstants;
import com.qaprosoft.carina.demo.utils.TabHandler;
import com.qaprosoft.carina.demo.utils.StringGenerator;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomePageWebTest implements IAbstractTest {

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "Vasyl Laba")
    @TestPriority(Priority.P1)
    public void testFooterMenuButtons(FooterMenuButtons footerMenuButton, String url) {
        // Open GSM Arena home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Scroll down to the footer menu and check if footer is on screen
        homePage.ScrollDownToFooterMenu();
        Assert.assertTrue(homePage.getFooterMenu().isElementPresent(), "News page is not opened!");

        //check if buttons on the menu present
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isElementPresent(), "FooterMenu is not present!");

        footerMenu.clickButton(footerMenuButton);
        TabHandler.switchBetweenPages(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @DataProvider(parallel = false, name = "DP1")
    public Object[][] footerMenuButtonsDataProvider() {
        return new Object[][]{
                {FooterMenuButtons.NEWS, ProjectConstants.NEWS_PAGE_URL},
                {FooterMenuButtons.REVIEWS, ProjectConstants.REVIEWS_PAGE_URL},
                {FooterMenuButtons.COMPARE, ProjectConstants.COMPARE_PAGE_URL},
                {FooterMenuButtons.COVERAGE, ProjectConstants.COVERAGE_PAGE_URL},
                {FooterMenuButtons.GLOSSARY, ProjectConstants.GLOSSARY_PAGE_URL},
                {FooterMenuButtons.FAQ, ProjectConstants.FAQ_PAGE_URL},
                {FooterMenuButtons.RSS_FEED, ProjectConstants.RSS_FEED_PAGE_URL},
                {FooterMenuButtons.YOUTUBE, ProjectConstants.YOUTUBE_PAGE_URL},
                {FooterMenuButtons.FACEBOOK, ProjectConstants.FACEBOOK_PAGE_URL},
                {FooterMenuButtons.TWITTER, ProjectConstants.TWITTER_PAGE_URL},
                {FooterMenuButtons.INSTAGRAM, ProjectConstants.INSTAGRAM_PAGE_URL},
                {FooterMenuButtons.TEAM, ProjectConstants.TEAM_PAGE_URL},
                {FooterMenuButtons.MOBILE_VERSION, ProjectConstants.HOME_PAGE_MOBILE_VERSION_URL},
                {FooterMenuButtons.ANDROID_APP, ProjectConstants.ANDROID_APP_URL},
                {FooterMenuButtons.TOOLS, ProjectConstants.TOOLS_PAGE_URL},
                {FooterMenuButtons.CONTACT_US, ProjectConstants.CONTACT_PAGE_URL},
                {FooterMenuButtons.MERCH_STORE, ProjectConstants.MERCH_PAGE_URL},
                {FooterMenuButtons.PRIVACY, ProjectConstants.PRIVACY_PAGE_URL},
                {FooterMenuButtons.TERM_OF_USE, ProjectConstants.TERM_OF_USE_PAGE_URL}
        };
    }


    @Test()
    @MethodOwner(owner = "Vasyl Laba")
    @TestPriority(Priority.P2)
    public void testHeaderMenuButtons() {
        // Open GSM Arena home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //search header menu and click toggle button to open header menu
        HeaderMenu headerMenu = homePage.getHeaderMenu().clickToggleNavigationButton();

        //check if all buttons on the menu present
        Assert.assertTrue(headerMenu.isAllButtonsPresent(), "Some element do not present");

        //click on each button and check if we go to the next Page
        headerMenu.clickNewsButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.NEWS_PAGE_URL, "Page url does not match");

        headerMenu.clickReviewsButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.REVIEWS_PAGE_URL, "Page url does not match");

        headerMenu.clickVideosPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.VIDEOS_PAGE_URL, "Page url does not match");

        headerMenu.clickFeaturedPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.FEATURED_PAGE_URL, "Page url does not match");

        headerMenu.clickPhoneFinderPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.PHONE_FINDER_PAGE_URL, "Page url does not match");

        headerMenu.clickDealsPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.DEALS_PAGE_URL, "Page url does not match");

        headerMenu.clickMerchPageButton();
        TabHandler.switchBetweenPages(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.MERCH_PAGE_URL, "Page url does not match");
        TabHandler.closeCurrentPage(getDriver());
        TabHandler.switchBetweenPages(getDriver());

        headerMenu.clickCoveragePageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.COVERAGE_PAGE_URL, "Page url does not match");

        headerMenu.clickContactPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.CONTACT_PAGE_URL, "Page url does not match");

    }

    @Test()
    @MethodOwner(owner = "Vasyl Laba")
    @TestPriority(Priority.P3)
    public void testSignUpElements() {
        // Open GSM Arena home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //click on the button “Sing up”
        SignUpPage signUpPage = homePage.getHeaderMenu().clickSignUpButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.SIGN_UP_PAGE_URL, "Page url does not match");

        //check if all elements on the SingUp Page present
        //here I use two types of checks (in page class and in test class) just for example
        signUpPage.validateAccountElementsIfPresent();
        validateAccountElementsIfPresent(signUpPage);

        //fill in all info to create new account
        signUpPage.fillInNewUserInfo(StringGenerator.generateLogin(),
                StringGenerator.generateEmail(),
                "12345678AAa",
                true,
                true);

        //click Submit button
        signUpPage.clickSubmitButton();
        Assert.assertTrue(signUpPage.getResultMessage().isElementPresent(), "Result message do not present");

    }

    @Test()
    @MethodOwner(owner = "Vasyl Laba")
    @TestPriority(Priority.P4)
    public void testLogInProcess() {
        // Open GSM Arena home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //click on the button “Log in”
        LogInModal loginModal = homePage.getHeaderMenu().clickLogInButton();

        //Check all elements on the LogIn Modal - if elements present
        SoftAssert softAssert = new SoftAssert();
        loginModal.validateLogInModalElementsIfPresent(softAssert);
        loginModal.validateLogInModalElementsIfVisible(softAssert);
        softAssert.assertAll();

        LogInPage logInPage = loginModal.loginToAccount("vasylLabaTesterUser@gmail.com", "12345678AAa");

        //check if was opened next page
        Assert.assertTrue(logInPage.isPresent(), "LogInPage object is not present");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "LoginData", dsUid = "TUID", dsArgs = "email, password, expectedMessage")
    @MethodOwner(owner = "Vasyl Laba")
    @TestPriority(Priority.P4)
    public void testLogInProcessWithInvalidInput(String email, String password, String expectedMessage) {
        // Open GSM Arena home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LogInModal loginModal = homePage.getHeaderMenu().clickLogInButton();
        //try to log in with invalid email
        LogInPage logInPage = loginModal.loginToAccount(email, password);

        //check if was opened next page
        Assert.assertEquals(loginModal.getEmailInput().getAttribute("validationMessage"), expectedMessage,
                "Incorrect message");
    }

    public void validateAccountElementsIfPresent(SignUpPage signUpPage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signUpPage.isNicknameInputPresent(), "Nickname element is not present");

        softAssert.assertAll();
    }

}
