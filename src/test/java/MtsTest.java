import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        WebElement acceptCookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()) {
            acceptCookieButton.click();
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCheckPaymentSectionTitle() {
        WebElement paymentSectionTitle = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        String actualTitle = paymentSectionTitle.getText();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertTrue(actualTitle.contains(expectedTitle));
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testCheckPaymentPartnersLogo() {
        WebElement paymentPartnersLogos = driver.findElement(By.xpath("//div[@class = 'pay__partners']/ul"));
        List<String> expectedLogos = Arrays.asList("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        for (String text:expectedLogos) {
            WebElement paymentPartnerLogo = paymentPartnersLogos.findElement(By.xpath(".//img[@alt='" + text + "']"));
            assertTrue(paymentPartnerLogo.isDisplayed());
        }
    }

    @Test
    public void testCheckLinkMoreDetails() {
        WebElement linkMoreDetails = driver.findElement(By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        String originalWindow = driver.getWindowHandle();
        linkMoreDetails.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //String windowHandle = driver.getWindowHandle();
        //driver.switchTo().window(windowHandle);
        WebElement newPageCheck = driver.findElement(By.xpath("//span[@itemprop='item']/span"));
        String actualLink = newPageCheck.getText();
        String expectedLink = "Порядок оплаты и безопасность интернет платежей";
        assertTrue(actualLink.contains(expectedLink));
        assertEquals(expectedLink, actualLink);
    }

    @Test
    public void testCheckContinueButton() {
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumber.sendKeys("297777777");
        WebElement sum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sum.sendKeys("5");
        WebElement email = driver.findElement(By.xpath("//input[@id='connection-email']"));
        email.sendKeys("mail@gmail.com");
        WebElement continueButton = driver.findElement(By.xpath("//form[@class='pay-form opened']/button"));
        continueButton.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement payButton = driver.findElement(By.xpath("//div[@class='card-page__card']/button"));
        //String actualButtonText = payButton.getText();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualButtonText = (String) js.executeScript("return arguments[0].textContent;", payButton);
        String expectedButtonText = " Оплатить  5.00 BYN ";
        assertTrue(actualButtonText.contains(expectedButtonText));
        assertEquals(expectedButtonText, actualButtonText);
        driver.switchTo().defaultContent();



    }

}
