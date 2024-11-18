package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "cookie-agree")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//section[@class='pay']//h2")
    private WebElement paymentSectionTitle;

    @FindBy(xpath = "//div[@class = 'pay__partners']/ul")
    private WebElement paymentPartnersLogos;

    @FindBy(xpath = "//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']")
    private WebElement linkMoreDetails;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//form[@class='pay-form opened']/button")
    private WebElement continueButton;

    @FindBy(xpath = "//form[@class='pay-form opened']//input")
    private List<WebElement> selectedFormInputs;

    @FindBy(xpath = "//form[@id='pay-internet']//input")
    private List<WebElement> internetFormInputs;

    @FindBy(xpath = "//form[@id='pay-instalment']//input")
    private List<WebElement> instalmentFormInputs;

    @FindBy(xpath = "//form[@id='pay-arrears']//input")
    private List<WebElement> arrearsFormInputs;

    @FindBy(xpath = "//span[@itemprop='item']/span")
    private WebElement newPageCheckText;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payDescriptionText;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span[contains(text(),'BYN')]")
    private WebElement payDescriptionCost;

    @FindBy(xpath = "//label[@class='ng-tns-c46-1 ng-star-inserted']")
    private WebElement creditCardInputLabel;

    @FindBy(xpath = "//label[@class='ng-tns-c46-4 ng-star-inserted']")
    private WebElement expirationDataInputLabel;

    @FindBy(xpath = "//label[@class='ng-tns-c46-5 ng-star-inserted']")
    private WebElement cvcInputLabel;

    @FindBy(xpath = "//label[@class='ng-tns-c46-3 ng-star-inserted']")
    private WebElement cardholderNameInputLabel;

    @FindBy(xpath = "img[class='ng-tns-c61-0 ng-star-inserted']")
    private List<WebElement> paymentCreditCardInputLogos;

    @FindBy(xpath = "//img[@class='ng-tns-c61-0 ng-trigger ng-trigger-randomCardState ng-star-inserted']")
    private WebElement paymentCreditCardInputMirLogo;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()) {
            acceptCookieButton.click();
        }
    }

    public String getPaymentSectionTitle() {
        return paymentSectionTitle.getText();
    }

    public boolean isPartnerLogoDisplayed(String altText) {
        WebElement logo = paymentPartnersLogos.findElement(By.xpath(".//img[@alt='" + altText + "']"));
        return logo.isDisplayed();
    }

    public void clickMoreDetails() {
        linkMoreDetails.click();
    }

    public void fillPaymentForm(String phoneNumber, String sum, String email) {
        phoneNumberInput.sendKeys(phoneNumber);
        sumInput.sendKeys(sum);
        emailInput.sendKeys(email);
        continueButton.click();
    }

    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
    }

    public String getPayButtonTextInIframe() {
        switchToIframe();
        WebElement payButton = driver.findElement(By.xpath("//div[@class='card-page__card']/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String payButtonText = (String) js.executeScript("return arguments[0].textContent;", payButton);
        return payButtonText;
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public List<String> getSelectedFormInputPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement placeholder : selectedFormInputs) {
            placeholders.add(placeholder.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public List<String> getInternetFormInputPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement placeholder : internetFormInputs) {
            placeholders.add(placeholder.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public List<String> getInstalmentFormInputPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement placeholder : instalmentFormInputs) {
            placeholders.add(placeholder.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public List<String> getArrearsFormInputPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement placeholder : arrearsFormInputs) {
            placeholders.add(placeholder.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public void switchWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public String getNewPageCheckText() {
        return newPageCheckText.getText();
    }

    public String getPayDescriptionText() {
        switchToIframe();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String payDescriptionText = (String) js.executeScript("return arguments[0].textContent;", this.payDescriptionText);
        return payDescriptionText;
    }

    public String getPayDescriptionCost() {
        switchToIframe();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String payDescriptionCost = (String) js.executeScript("return arguments[0].textContent;", this.payDescriptionCost);
        return payDescriptionCost;
    }

    public String getCreditCardInputLabel() {
        switchToIframe();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String creditCardInputLabel = (String) js.executeScript("return arguments[0].textContent;", this.creditCardInputLabel);
        return creditCardInputLabel;
    }

    public String getExpirationDataInputLabel() {
        switchToIframe();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String expirationDataInputLabel = (String) js.executeScript("return arguments[0].textContent;", this.expirationDataInputLabel);
        return expirationDataInputLabel;
    }

    public String getCvcInputLabel() {
        switchToIframe();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String cvcInputLabel = (String) js.executeScript("return arguments[0].textContent;", this.cvcInputLabel);
        return cvcInputLabel;
    }

    public String getCardholderNameInputLabel() {
        switchToIframe();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String cardholderNameInputLabel = (String) js.executeScript("return arguments[0].textContent;", this.cardholderNameInputLabel);
        return cardholderNameInputLabel;
    }

    public boolean arePaymentCreditCardInputLogosDisplayed() {
        switchToIframe();
        for (WebElement paymentLogo : paymentCreditCardInputLogos) {
            if (!paymentLogo.isDisplayed()) {
                return false;
            }
        }
        return true;

    }

    public boolean isPaymentCreditCardInputMirLogoDisplayed() {
        switchToIframe();
        return paymentCreditCardInputMirLogo.isDisplayed();
    }
}