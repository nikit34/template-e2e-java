package pt.devexperts;

import org.junit.jupiter.api.Test;
import pt.devexperts.labels.TestLayer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static pt.devexperts.pages.BasePage.mainPage;


@TestLayer(TestLayer.Type.REGRESS)
public class MainTests extends BaseTest {

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
