package org.test;

import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;
import org.steps.DriverInstance;
import org.steps.MainPageSteps;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

@ExtendWith(AllureJunit5.class)

@Epic("Тестирование онлайн пополнения")
@Feature("Оплата услуг связи")
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
    @DisplayName("Проверка видимости логотипов платежных систем")
    @Story("Отображение иконок логотипов платежных систем")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка видимости логотипов платежных систем в поле Номер карты")
    public void testCheckPaymentCardInputLogos() {
        mainPageSteps.fillPaymentFormAndSubmit("297777777", "5", "mail@gmail.com");
        mainPageSteps.switchToFrame();
        boolean result = mainPageSteps.arePaymentCreditCardInputLogosDisplayed();
        assertTrue(result);
        mainPageSteps.switchToDefaultContent();
    }
}