package pt.devexperts;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

import static org.openqa.selenium.chrome.ChromeOptions.LOGGING_PREFS;


public class WebDriverProvider {

    public static void init() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15_000;
        Configuration.baseUrl = "https://www.google.com";
    }

    public static void setup() {
        final WebDriver driver = createWebDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    private static WebDriver createWebDriver() {
        final ChromeOptions options = new ChromeOptions();

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability(LOGGING_PREFS, logPrefs);

//        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }
}
