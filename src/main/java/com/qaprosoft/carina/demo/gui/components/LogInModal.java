package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInModal extends AbstractUIObject {

    @FindBy(xpath = "//span[@class='tooltip']//p")
    private ExtendedWebElement loginTitle;

    @FindBy(xpath = "//span[@class='tooltip']//input[@id='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//span[@class='tooltip']//input[@id='upass']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//span[@class='tooltip']//input[@id='nick-submit']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//span[@class='tooltip']//a[@class='forgot']")
    private ExtendedWebElement forgotPasswordLink;

    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }

    public ExtendedWebElement getLogInButton() {
        return logInButton;
    }

    public ExtendedWebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public ExtendedWebElement getLoginTitle() {
        return loginTitle;
    }

    public LogInModal(WebDriver driver) {
        super(driver);
    }

    public boolean isVisible() {
        if (!isPresent())
            return false;
        if (!getLoginTitle().isVisible())
            return false;
        if (!getEmailInput().isVisible())
            return false;
        if (!getPasswordInput().isVisible())
            return false;
        if (!getLogInButton().isVisible())
            return false;
        return getForgotPasswordLink().isVisible();
    }

    private boolean isPresent() {
        if (!getLoginTitle().isElementPresent())
            return false;
        if (!getEmailInput().isElementPresent())
            return false;
        if (!getPasswordInput().isElementPresent())
            return false;
        if (!getLogInButton().isElementPresent())
            return false;
        return getForgotPasswordLink().isElementPresent();
    }

    public void fillInEmailInput(String email) {
        emailInput.type(email);
    }

    public void fillInPasswordInput(String password) {
        passwordInput.type(password);
    }

    public LogInPage clickLogInButton() {
        logInButton.click();
        return new LogInPage(driver);
    }

    public LogInPage loginToAccount(String email, String password) {
        fillInEmailInput(email);
        fillInPasswordInput(password);
        return clickLogInButton();
    }

}
