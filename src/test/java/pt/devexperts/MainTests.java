package pt.devexperts;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pt.devexperts.testdata.ProductsConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static pt.devexperts.pages.BasePage.mainPage;


public class MainTests extends BaseTest {
    private static final ProductsConfig PRODUCTS_CONFIG = ConfigFactory.create(ProductsConfig.class, getProperties());

    @Test
    public void testProductVisibleOnMainPage() {
        open("/");

        mainPage.productPrice(PRODUCTS_CONFIG.title())
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.priceCurrency() + PRODUCTS_CONFIG.price()));
        mainPage.productTitle(PRODUCTS_CONFIG.title())
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.title()));
    }
}
