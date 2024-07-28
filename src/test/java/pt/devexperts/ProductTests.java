package pt.devexperts;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pt.devexperts.configs.testdata.ElementsConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static pt.devexperts.pages.BasePage.mainPage;
import static pt.devexperts.pages.BasePage.productPage;


public class ProductTests extends BaseTest {
    private static final ElementsConfig ELEMENTS_CONFIG = ConfigFactory.create(ElementsConfig.class, getProperties());

    @Test
    public void testProductVisibleOnProductPage() {
        open("/");

        mainPage.productTitle(PRODUCTS_CONFIG.title())
                .shouldBe(visible)
                .click();

        productPage.productTitle()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.title()));
        productPage.productPrice()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.priceCurrency() + PRODUCTS_CONFIG.price()));
        productPage.addToCartBtn()
                .shouldBe(visible)
                .shouldHave(text(ELEMENTS_CONFIG.btnAddToCart()));
    }
}
