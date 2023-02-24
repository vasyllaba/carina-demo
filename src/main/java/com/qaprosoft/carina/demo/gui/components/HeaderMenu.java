package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//button[@aria-label='Toggle Navigation']")
    private ExtendedWebElement toggleNavigationButton;

    @FindBy(xpath = "//header//ul[@id='menu']//li//a[@href]")
    private List<ExtendedWebElement> footerMenuButtons;

    @FindBy(xpath = "//header//ul//li//a[@href='/']")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//header//ul//li//a[@href='news.php3']")
    private ExtendedWebElement newsButton;

    @FindBy(xpath = "//header//ul//li//a[@href='reviews.php3']")
    private ExtendedWebElement reviewsButton;

    @FindBy(xpath = "//header//ul//li//a[@href='videos.php3']")
    private ExtendedWebElement videosButton;

    @FindBy(xpath = "//header//ul//li//a[@href='news.php3?sTag=Featured']")
    private ExtendedWebElement featuredButton;

    @FindBy(xpath = "//header//ul//li//a[@href='search.php3']")
    private ExtendedWebElement phoneFinderButton;

    @FindBy(xpath = "//header//ul//li//a[@href='deals.php3']")
    private ExtendedWebElement dealsButton;

    @FindBy(xpath = "//header//ul//li//a[@href='https://merch.gsmarena.com/']")
    private ExtendedWebElement merchButton;

    @FindBy(xpath = "//header//ul//li//a[@href='network-bands.php3']")
    private ExtendedWebElement coverageButton;

    @FindBy(xpath = "//header//ul//li//a[@href='contact.php3']")
    private ExtendedWebElement contactButton;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//a[@class='login-icon']")
    private ExtendedWebElement logInButton;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HeaderMenu clickToggleNavigationButton() {
        toggleNavigationButton.click();
        return this;
    }

    public List<ExtendedWebElement> getFooterMenuButtons() {
        return footerMenuButtons;
    }

    public boolean isAllButtonsPresent() {
        ExtendedWebElement[] webElements = footerMenuButtons.toArray(new ExtendedWebElement[0]);
        return allElementsPresent(webElements);
    }

    public NewsPage clickNewsButton() {
        newsButton.click();
        return new NewsPage(driver);
    }

    public ReviewsPage clickReviewsButton() {
        reviewsButton.click();
        return new ReviewsPage(driver);
    }

    public VideosPage clickVideosPageButton() {
        videosButton.click();
        return new VideosPage(driver);
    }

    public FeaturedPage clickFeaturedPageButton() {
        featuredButton.click();
        return new FeaturedPage(driver);
    }

    public PhoneFinderPage clickPhoneFinderPageButton() {
        phoneFinderButton.click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage clickDealsPageButton() {
        dealsButton.click();
        return new DealsPage(driver);
    }

    public MerchPage clickMerchPageButton() {
        merchButton.click();
        return new MerchPage(driver);
    }

    public CoveragePage clickCoveragePageButton() {
        coverageButton.click();
        return new CoveragePage(driver);
    }

    public ContactPage clickContactPageButton() {
        contactButton.click();
        return new ContactPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public LogInModal clickLogInButton() {
        logInButton.click();
        return new LogInModal(driver);
    }


}
