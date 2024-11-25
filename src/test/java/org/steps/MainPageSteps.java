package org.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.pages.MainPage;

public class MainPageSteps {
    private final MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    @Step("Принятие cookie")
    public void acceptCookies() {
        mainPage.acceptCookies();
    }

    @Step("Заполнение формы корректными данными и нажатие кнопки Продолжить")
    public void fillPaymentFormAndSubmit(String phoneNumber, String sum, String email) {
        mainPage.fillPaymentForm(phoneNumber, sum, email);
    }

    @Step("Переключение на фрейм")
    public void switchToFrame() {
        mainPage.switchToIframe();
    }

    @Step("Выход из фрейма")
    public void switchToDefaultContent() {
        mainPage.switchToDefaultContent();
    }

    @Step("Проверка видимости логотипов")
    public boolean arePaymentCreditCardInputLogosDisplayed() {
        return mainPage.arePaymentCreditCardInputLogosDisplayed();
    }

}
