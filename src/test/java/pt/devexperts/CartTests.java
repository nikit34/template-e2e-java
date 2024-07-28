package pt.devexperts;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pt.devexperts.configs.testdata.ElementsConfig;
import pt.devexperts.labels.TestLayer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static pt.devexperts.Actions.waitAndAcceptAlert;
import static pt.devexperts.pages.BasePage.cartPage;
import static pt.devexperts.pages.BasePage.mainPage;
import static pt.devexperts.pages.BasePage.productPage;


@TestLayer({TestLayer.Type.SMOKE, TestLayer.Type.REGRESS})
public class CartTests extends BaseTest {
    private static final ElementsConfig ELEMENTS_CONFIG = ConfigFactory.create(ElementsConfig.class, getProperties());

    @Test
    public void testAddProductToCart() {
        open("/");

        mainPage.productTitle(PRODUCTS_CONFIG.title())
                .shouldBe(visible)
                .click();

        productPage.addToCartBtn()
                .shouldBe(visible)
                .click();

        waitAndAcceptAlert();

        open("/cart.html");

        cartPage.getFirstTableRow().title()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.title()));
        cartPage.getFirstTableRow().price()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.price()));
    }

    @Test
    public void testRemoveProductFromCart() {
        open("/");

        mainPage.productTitle(PRODUCTS_CONFIG.title())
                .shouldBe(visible)
                .click();

        productPage.addToCartBtn()
                .shouldBe(visible)
                .click();

        waitAndAcceptAlert();

        open("/cart.html");

        cartPage.getFirstTableRow().removeBtn()
                .shouldBe(visible)
                .shouldHave(text(ELEMENTS_CONFIG.btnDeleteFromCart()))
                .click();
        cartPage.getFirstTableRow().title()
                .shouldNotBe(visible);
        cartPage.getFirstTableRow().price()
                .shouldNotBe(visible);
    }
}
