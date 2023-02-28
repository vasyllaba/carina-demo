package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LogInModal;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.projectConstants.ProjectConstants;
import com.qaprosoft.carina.demo.utils.PageHandler;
import com.qaprosoft.carina.demo.utils.StringGenerator;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageWebTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Vasyl Laba")
    @TestPriority(Priority.P1)
    public void testFooterMenuButtons() {
        // Open GSM Arena home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Scroll down to the footer menu and check if footer is on screen
        homePage.ScrollDownToFooterMenu();
        Assert.assertTrue(homePage.getFooterMenu().isElementPresent(), "News page is not opened!");

        //check if buttons on the menu present
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "Page is not opened!");
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
        PageHandler.switchBetweenPages(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.MERCH_PAGE_URL, "Page url does not match");
        PageHandler.closeCurrentPage(getDriver());
        PageHandler.switchBetweenPages(getDriver());

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
        SignUpPage sp = homePage.getHeaderMenu().clickSignUpButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), ProjectConstants.SIGN_UP_PAGE_URL, "Page url does not match");

        //check if all elements on the SingUp Page present
        Assert.assertTrue(sp.isCreateAccountElementsPresent(), "Some element in create account menu do not present");

        //fill in all info to create new account
        sp.fillInNewUserInfo(StringGenerator.generateLogin(),
                StringGenerator.generateEmail(),
                "12345678AAa",
                true,
                true);

        //click Submit button
        sp.clickSubmitButton();
        Assert.assertTrue(sp.getResultMessage().isElementPresent(), "Result message do not present");

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
        Assert.assertTrue(loginModal.isVisible(), "Log In modal object is not visible");

        LogInPage logInPage = loginModal.loginToAccount("vasylLabaTesterUser@gmail.com", "12345678AAa");

        //check if was opened next page
        Assert.assertTrue(logInPage.isPresent(), "LogInPage object is not present");
    }

}
