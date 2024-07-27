package pt.devexperts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class CartTests extends BaseTest {

    @Test
    public void testGoogleSearch() {
        open();

        SelenideElement searchBox = $("[name='q']");
        searchBox.setValue("Selenium WebDriver").pressEnter();

        $$("#search .g").first().shouldHave(Condition.text("Selenium WebDriver"));
    }
}
