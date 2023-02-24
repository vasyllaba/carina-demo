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

    public ExtendedWebElement getLoginTitle() {
        return loginTitle;
    }

    public LogInModal(WebDriver driver) {
        super(driver);
    }

    public boolean isVisible() {
        return isPresent() &&
                loginTitle.isVisible() &&
                emailInput.isVisible() &&
                passwordInput.isVisible() &&
                logInButton.isVisible() &&
                forgotPasswordLink.isVisible();
    }

    private boolean isPresent() {
        return loginTitle.isPresent() &&
                emailInput.isPresent() &&
                passwordInput.isPresent() &&
                logInButton.isPresent() &&
                forgotPasswordLink.isPresent();
    }

    public void fillInEmailInput(String email) {
        validateEmail(email);
        emailInput.type(email);
    }

    public void fillInPasswordInput(String password) {
        validatePassword(password);
        passwordInput.type(password);
    }

    public LogInPage clickLogInButton() {
        logInButton.click();
        return new LogInPage(driver);
    }

    private void validateEmail(String email){
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("Invalid email");
    }

    private void validatePassword(String password){
        if (!password.matches("^[\\w-]{8,40}$"))
            throw new IllegalArgumentException("Invalid password");
    }

}
