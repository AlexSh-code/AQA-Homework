package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "cookie-agree")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//form[@class='pay-form opened']/button")
    private WebElement continueButton;

    @FindBy(xpath = "img[class='ng-tns-c61-0 ng-star-inserted']")
    private List<WebElement> paymentCreditCardInputLogos;

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

    public void fillPaymentForm(String phoneNumber, String sum, String email) {
        phoneNumberInput.sendKeys(phoneNumber);
        sumInput.sendKeys(sum);
        emailInput.sendKeys(email);
        continueButton.click();
    }

    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public boolean arePaymentCreditCardInputLogosDisplayed() {
        for (WebElement paymentLogo : paymentCreditCardInputLogos) {
            if (!paymentLogo.isDisplayed()) {
                return false;
            }
        }
        return true;

    }
}
