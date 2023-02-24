package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='article-hgroup']/h1[@class='article-info-name']")
    private ExtendedWebElement loginResult;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPresent() {
        return loginResult.isPresent();
    }
}
