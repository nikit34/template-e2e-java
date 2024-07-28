package pt.devexperts;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Actions {
    private final ChromeDriver driver;

    private static class Holder {
        private static final Actions INSTANCE = new Actions();
    }

    private Actions() {
        this.driver = (ChromeDriver) WebDriverRunner.getWebDriver();
    }

    public static Actions getInstance() {
        return Holder.INSTANCE;
    }

    public void waitAndAcceptAlert() {
        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        Alert alert = this.driver.switchTo().alert();
        alert.accept();
    }
}
