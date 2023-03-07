package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LogInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

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

    public LogInModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LogInModal(WebDriver driver) {
        super(driver);
    }

    public void validateLogInModalElementsIfVisible(SoftAssert softAssert) {
        validateLogInModalElementsIfPresent(softAssert);
        softAssert.assertTrue(getLoginTitle().isVisible(), "Login title is not visible");
        softAssert.assertTrue(getEmailInput().isVisible(), "Email input is not visible");
        softAssert.assertTrue(getPasswordInput().isVisible(), "Password input is not visible");
        softAssert.assertTrue(getLogInButton().isVisible(), "Login button is not visible");
        softAssert.assertTrue(getForgotPasswordLink().isVisible(), "ForgotPassword link is not visible");
    }

    private void validateLogInModalElementsIfPresent(SoftAssert softAssert) {
        softAssert.assertTrue(getLoginTitle().isElementPresent(), "Login title is not present");
        softAssert.assertTrue(getEmailInput().isElementPresent(), "Email input is not present");
        softAssert.assertTrue(getPasswordInput().isElementPresent(), "Password input is not present");
        softAssert.assertTrue(getLogInButton().isElementPresent(), "Login button is not present");
        softAssert.assertTrue(getForgotPasswordLink().isElementPresent(), "ForgotPassword link is not present");
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
