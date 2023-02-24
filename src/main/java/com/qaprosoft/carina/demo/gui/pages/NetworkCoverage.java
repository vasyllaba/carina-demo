package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NetworkCoverage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement networkCoverageTitle;

    public NetworkCoverage(WebDriver driver) {
        super(driver);
    }

    public boolean isNetworkCoverageTitlePresent(){
        return networkCoverageTitle.isElementPresent();
    }
}
