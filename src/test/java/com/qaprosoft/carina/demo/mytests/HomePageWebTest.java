package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LogInModal;
import com.qaprosoft.carina.demo.gui.emuns.FooterMenuButtons;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class HomePageWebTest implements IAbstractTest {
    private final String NEWS_PAGE_URL = "https://www.gsmarena.com/news.php3";
    private final String REVIEWS_PAGE_URL = "https://www.gsmarena.com/reviews.php3";
    private final String VIDEOS_PAGE_URL = "https://www.gsmarena.com/videos.php3";
    private final String FEATURED_PAGE_URL = "https://www.gsmarena.com/news.php3?sTag=Featured";
    private final String PHONE_FINDER_PAGE_URL = "https://www.gsmarena.com/search.php3?";
    private final String DEALS_PAGE_URL = "https://www.gsmarena.com/deals.php3";
    private final String MERCH_PAGE_URL = "https://merch.gsmarena.com/";
    private final String COVERAGE_PAGE_URL = "https://www.gsmarena.com/network-bands.php3";
    private final String CONTACT_PAGE_URL = "https://www.gsmarena.com/contact.php3";
    private final String SIGN_UP_PAGE_URL = "https://www.gsmarena.com/register.php3";

    @Test()
    @MethodOwner(owner = "Vasyl Laba")
    @TestPriority(Priority.P1)
    public void testFooterMenuButtons() {
        // Open GSM Arena home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Scroll down to the footer menu
        homePage.ScrollDownToFooterMenu();
        //check if footer is on screen
        Assert.assertTrue(homePage.getFooterMenu().isElementPresent(), "News page is not opened!");

        //check if all buttons on the menu present
        FooterMenu footerMenu = homePage.getFooterMenu();
        footerMenu.clickFooterButton(FooterMenuButtons.COVERAGE);
        NetworkCoverage networkCoverage = new NetworkCoverage(getDriver());
        Assert.assertTrue(networkCoverage.isNetworkCoverageTitlePresent(), "Title is not present!");
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
        Assert.assertEquals(getDriver().getCurrentUrl(), NEWS_PAGE_URL, "Page url does not match");

        headerMenu.clickReviewsButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), REVIEWS_PAGE_URL, "Page url does not match");

        headerMenu.clickVideosPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), VIDEOS_PAGE_URL, "Page url does not match");

        headerMenu.clickFeaturedPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), FEATURED_PAGE_URL, "Page url does not match");

        headerMenu.clickPhoneFinderPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), PHONE_FINDER_PAGE_URL, "Page url does not match");

        headerMenu.clickDealsPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), DEALS_PAGE_URL, "Page url does not match");

        headerMenu.clickCoveragePageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), COVERAGE_PAGE_URL, "Page url does not match");

        headerMenu.clickContactPageButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), CONTACT_PAGE_URL, "Page url does not match");

        String originalWindow = getDriver().getWindowHandle();
        MerchPage mp = headerMenu.clickMerchPageButton();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(getDriver().getCurrentUrl(), MERCH_PAGE_URL, "Page url does not match");

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
        Assert.assertEquals(getDriver().getCurrentUrl(), SIGN_UP_PAGE_URL, "Page url does not match");

        //check if all elements on the SingUp Page present
        Assert.assertTrue(sp.isCreateAccountElementsPresent(), "Some element in create account menu do not present");

        //fill in all info to create new account
        sp.fillInNewUserInfo("vasylLabaTesterUser",
                "vasylLabaTesterUser@gmail.com",
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
        LogInModal lm = homePage.getHeaderMenu().clickLogInButton();
        pause(2);
        Assert.assertTrue(lm.isUIObjectPresent(),
                "Log In modal object is not visible");

    }

}
