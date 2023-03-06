package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

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

    public void validateAccountElementsIfPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isNicknameInputPresent(), "Nickname input is not present");
        softAssert.assertTrue(isEmailInputPresent(), "Email input is not present");
        softAssert.assertTrue(isPasswordInputPresent(), "Password input is not present");
        softAssert.assertTrue(isStoreDataAgreeCheckboxLabelInputPresent(), "Store data checkbox is not present");
        softAssert.assertTrue(isAgeAgreeCheckboxLabelPresent(), "Age agree checkbox is not present");
        softAssert.assertTrue(isSubmitButtonPresent(), "Submit button is not present");
        softAssert.assertAll();
    }

    public void fillInNewUserInfo(String nickName, String email, String password, boolean storeData, boolean ageAgree) {
        nicknameInput.type(nickName);
        emailInput.type(email);
        passwordInput.type(password);
        if (storeData)
            storeDataAgreeCheckboxLabel.clickByJs();
        if (ageAgree)
            ageAgreeCheckboxLabel.clickByJs();
    }

    public SignUpPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public boolean isNicknameInputPresent() {
        return nicknameInput.isElementPresent();
    }

    public boolean isEmailInputPresent() {
        return emailInput.isElementPresent();
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent();
    }

    public boolean isStoreDataAgreeCheckboxLabelInputPresent() {
        return storeDataAgreeCheckboxLabel.isElementPresent();
    }

    public boolean isAgeAgreeCheckboxLabelPresent() {
        return ageAgreeCheckboxLabel.isElementPresent();
    }

    public boolean isSubmitButtonPresent() {
        return submitButton.isElementPresent();
    }

}
