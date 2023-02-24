package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement titleHeading;

    @FindBy(xpath = "//input[@id='uname']")
    private ExtendedWebElement nicknameInput;

    @FindBy(xpath = "//fieldset[@id='udata-f']//input[@id='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//form[@id='frmOpin']//input[@id='upass']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement storeDataAgreeCheckboxLabel;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement ageAgreeCheckboxLabel;

    @FindBy(xpath = "//input[@class='button float-right']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'normal-text res')]")
    private ExtendedWebElement resultMessage;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getResultMessage() {
        return resultMessage;
    }

    public boolean isCreateAccountElementsPresent() {
        return nicknameInput.isElementPresent()
                && emailInput.isElementPresent()
                && passwordInput.isElementPresent()
                && storeDataAgreeCheckboxLabel.isElementPresent()
                && ageAgreeCheckboxLabel.isElementPresent()
                && submitButton.isElementPresent();
    }

    public void fillInNewUserInfo(String nickName, String email, String password, boolean storeDaya, boolean ageAgree) {
        nicknameInput.type(nickName);
        emailInput.type(email);
        passwordInput.type(password);
        if (storeDaya) storeDataAgreeCheckboxLabel.clickByJs();
        if (ageAgree) ageAgreeCheckboxLabel.clickByJs();
    }

    public SignUpPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
