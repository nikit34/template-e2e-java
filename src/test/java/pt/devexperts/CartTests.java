package pt.devexperts;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pt.devexperts.testdata.ElementsConfig;
import pt.devexperts.testdata.ProductsConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static pt.devexperts.pages.BasePage.mainPage;
import static pt.devexperts.pages.BasePage.productPage;


public class CartTests extends BaseTest {
    protected static final ProductsConfig PRODUCTS_CONFIG = ConfigFactory.create(ProductsConfig.class, getProperties());
    protected static final ElementsConfig ELEMENTS_CONFIG = ConfigFactory.create(ElementsConfig.class, getProperties());

    @Test
    public void testGoogleSearch() {
        open("/");

        mainPage.productPrice(PRODUCTS_CONFIG.productTitle())
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.productPrice()));
        mainPage.productTitle(PRODUCTS_CONFIG.productTitle())
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.productTitle()))
                .click();

        productPage.productTitle()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.productTitle()));
        productPage.productPrice()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.productPrice()));
        productPage.addToCartBtn()
                .shouldBe(visible)
                .shouldHave(text(ELEMENTS_CONFIG.btnAddToCart()))
                .click();

        Selenide.Wait().until(ExpectedConditions.alertIsPresent());
        ChromeDriver chromeDriver = (ChromeDriver) WebDriverRunner.getWebDriver();
        chromeDriver.switchTo().alert().accept();

        open("/cart.html");


    }
}
