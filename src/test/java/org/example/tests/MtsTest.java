package org.example.tests;

import org.example.steps.DriverInstance;
import org.example.steps.MainPageSteps;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MtsTest {
    private WebDriver driver;
    private MainPageSteps mainPageSteps;

    @BeforeEach
    public void setUp() {
        driver = DriverInstance.getInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        mainPageSteps = new MainPageSteps(driver);
        mainPageSteps.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        DriverInstance.quitInstance();
    }

    @Test
    public void testCheckPaymentSectionTitle() {
        String actualTitle = mainPageSteps.getPaymentSectionTitle();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertTrue(actualTitle.contains(expectedTitle));
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testCheckPaymentPartnersLogo() {
        String[] expectedLogos = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String logo : expectedLogos) {
            assertTrue(mainPageSteps.isPartnerLogoDisplayed(logo));
        }
    }

    @Test
    public void testCheckMoreDetailsLink() {
        mainPageSteps.clickMoreDetailsLink();
        mainPageSteps.switchWindow();
        //WebElement newPageCheck = driver.findElement(By.xpath("//span[@itemprop='item']/span"));
        String actualLink = mainPageSteps.newPageCheck();
        String expectedLink = "Порядок оплаты и безопасность интернет платежей";
        assertTrue(actualLink.contains(expectedLink));
        assertEquals(expectedLink, actualLink);
    }

    @Test
    public void testCheckContinueButton() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        String actualButtonText = mainPageSteps.verifyPayButtonInIframe();
        String expectedButtonText = " Оплатить  5.00 BYN ";
        assertTrue(actualButtonText.contains(expectedButtonText));
        assertEquals(expectedButtonText, actualButtonText);
        mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckSelectedFormInputPlaceholders() {
        List<String> actualPlaceholders = mainPageSteps.getSelectedFormInputPlaceholders();
        List<String> expectedPlaceholders = Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека");
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckInternetFormInputPlaceholders() {
        List<String> actualPlaceholders = mainPageSteps.getInternetInputPlaceholders();
        List<String> expectedPlaceholders = Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека");
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckInstalmentFormInputPlaceholders() {
        List<String> actualPlaceholders = mainPageSteps.getInstalmentFormInputPlaceholders();
        List<String> expectedPlaceholders = Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека");
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckArrearsFormInputPlaceholders() {
        List<String> actualPlaceholders = mainPageSteps.getArrearsFormInputPlaceholders();
        List<String> expectedPlaceholders = Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека");
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckNumberInIframe() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        String actualDescriptionText = mainPageSteps.getPayDescriptionText();
        String expectedDescriptionText = "375297777777";
        assertTrue(actualDescriptionText.contains((expectedDescriptionText)));
        mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckCostInFrame() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        String actualDescriptionCost = mainPageSteps.getPayDescriptionCost();
        String expectedDescriptionCost = "5.00 BYN";
        assertTrue(actualDescriptionCost.contains(expectedDescriptionCost));
        assertEquals(actualDescriptionCost, expectedDescriptionCost);
        mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckCreditCardInputLabel() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        String actualCreditCardInputLabel = mainPageSteps.getCreditCardInputLabel();
        String expectedCreditCardInputLabel = "Номер карты";
        assertTrue(actualCreditCardInputLabel.contains(expectedCreditCardInputLabel));
        assertEquals(actualCreditCardInputLabel, expectedCreditCardInputLabel);
        mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckExpirationDataInputLabel() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        String actualExpirationDataInputLabel = mainPageSteps.getExpirationDataInputLabel();
        String expectedExpirationDataInputLabel = "Срок действия";
        assertTrue(actualExpirationDataInputLabel.contains(expectedExpirationDataInputLabel));
        assertEquals(actualExpirationDataInputLabel, expectedExpirationDataInputLabel);
        mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckCvcInputLabel () {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        String actualCreditCardInputLabel = mainPageSteps.getCvcInputLabel();
        String expectedCvCCardInputLabel = "CVC";
        assertTrue(actualCreditCardInputLabel.contains(expectedCvCCardInputLabel));
        assertEquals(actualCreditCardInputLabel, expectedCvCCardInputLabel);
    mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckCardholderInputLabel() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        String actualCardholderInputLabel = mainPageSteps.getCardholderInputLabel();
        String expectedCardholderInputLabel = "Имя держателя (как на карте)";
        assertTrue(actualCardholderInputLabel.contains(expectedCardholderInputLabel));
        assertEquals(actualCardholderInputLabel, expectedCardholderInputLabel);
        mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckPaymentCardInputLogos() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        boolean result = mainPageSteps.arePaymentCreditCardInputLogosDisplayed();
        assertTrue(result);
        mainPageSteps.switchToDefaultContent();
    }

    @Test
    public void testCheckPaymentCreditCardInputMirLogo() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        boolean result = mainPageSteps.isPaymentCreditCardInputMirLogoDisplayed();
        assertTrue(result);
        mainPageSteps.switchToDefaultContent();
    }
}
