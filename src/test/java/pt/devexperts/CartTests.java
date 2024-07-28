package pt.devexperts;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pt.devexperts.pages.elements.CartRow;
import pt.devexperts.testdata.ElementsConfig;
import pt.devexperts.testdata.ProductsConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static pt.devexperts.pages.BasePage.cartPage;
import static pt.devexperts.pages.BasePage.mainPage;
import static pt.devexperts.pages.BasePage.productPage;


public class CartTests extends BaseTest {
    private static final ProductsConfig PRODUCTS_CONFIG = ConfigFactory.create(ProductsConfig.class, getProperties());
    private static final ElementsConfig ELEMENTS_CONFIG = ConfigFactory.create(ElementsConfig.class, getProperties());
    private static Actions ACTIONS = null;

    @BeforeEach
    public void setupTest() {
        ACTIONS = Actions.getInstance();
    }

    @Test
    public void testAddProductToCart() {
        open("/");

        mainPage.productPrice(PRODUCTS_CONFIG.title())
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.priceCurrency() + PRODUCTS_CONFIG.price()));
        mainPage.productTitle(PRODUCTS_CONFIG.title())
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.title()))
                .click();

        productPage.productTitle()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.title()));
        productPage.productPrice()
                .shouldBe(visible)
                .shouldHave(text(PRODUCTS_CONFIG.priceCurrency() + PRODUCTS_CONFIG.price()));
        productPage.addToCartBtn()
                .shouldBe(visible)
                .shouldHave(text(ELEMENTS_CONFIG.btnAddToCart()))
                .click();

        ACTIONS.waitAndAcceptAlert();

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

        ACTIONS.waitAndAcceptAlert();

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
