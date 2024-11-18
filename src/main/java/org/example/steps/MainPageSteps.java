package org.example.steps;

import org.openqa.selenium.WebDriver;
import org.example.pages.MainPage;

import java.util.List;

public class MainPageSteps {
    private final MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    public void acceptCookies() {
        mainPage.acceptCookies();
    }

    public String getPaymentSectionTitle() {
        return mainPage.getPaymentSectionTitle();
    }

    public boolean isPartnerLogoDisplayed(String altText) {
        return mainPage.isPartnerLogoDisplayed(altText);
    }

    public void clickMoreDetailsLink() {
        mainPage.clickMoreDetails();
    }

    public void fillPaymentFormAndSubmit(String phoneNumber, String sum, String email) {
        mainPage.fillPaymentForm(phoneNumber, sum, email);
    }

    public String verifyPayButtonInIframe() {
        return mainPage.getPayButtonTextInIframe();
    }

    public void switchToDefaultContent() {
        mainPage.switchToDefaultContent();
    }

    public List<String> getSelectedFormInputPlaceholders() {
        return mainPage.getSelectedFormInputPlaceholders();
    }

    public List<String> getInternetInputPlaceholders() {
        return mainPage.getInternetFormInputPlaceholders();
    }

    public List<String> getInstalmentFormInputPlaceholders() {
        return mainPage.getInstalmentFormInputPlaceholders();
    }

    public List<String> getArrearsFormInputPlaceholders() {
        return mainPage.getArrearsFormInputPlaceholders();
    }

    public void switchWindow() {
        mainPage.switchWindow();
    }

    public String newPageCheck() {
        return mainPage.getNewPageCheckText();
    }

    public String getPayDescriptionText() {
        return mainPage.getPayDescriptionText();
    }

    public String getPayDescriptionCost() {
        return mainPage.getPayDescriptionCost();
    }

    public String getCreditCardInputLabel() {
        return mainPage.getCreditCardInputLabel();
    }

    public String getExpirationDataInputLabel() {
        return mainPage.getExpirationDataInputLabel();
    }

    public String getCvcInputLabel() {
        return mainPage.getCvcInputLabel();
    }

    public String getCardholderInputLabel() {
        return mainPage.getCardholderNameInputLabel();
    }

    public boolean arePaymentCreditCardInputLogosDisplayed() {
        return mainPage.arePaymentCreditCardInputLogosDisplayed();
    }

    public boolean isPaymentCreditCardInputMirLogoDisplayed() {
        return mainPage.isPaymentCreditCardInputMirLogoDisplayed();
    }
}
