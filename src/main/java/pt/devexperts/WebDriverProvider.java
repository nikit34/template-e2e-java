package pt.devexperts;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import pt.devexperts.configs.RouterConfig;

import java.util.logging.Level;

import static org.openqa.selenium.chrome.ChromeOptions.LOGGING_PREFS;
import static pt.devexperts.properties.ConfigPropertiesService.getProperties;


public final class WebDriverProvider {
    private static final RouterConfig ROUTER_CONFIG = ConfigFactory.create(RouterConfig.class, getProperties());

    public static void init() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15_000;
        Configuration.baseUrl = ROUTER_CONFIG.baseUrl();
        Configuration.savePageSource = false;
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

    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
