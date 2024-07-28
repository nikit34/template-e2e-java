package pt.devexperts;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Actions {
    public static void waitAndAcceptAlert() {
        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        ChromeDriver driver = (ChromeDriver) WebDriverRunner.getWebDriver();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
