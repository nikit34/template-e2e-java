package pt.devexperts.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pt.devexperts.SelenideBlock;
import pt.devexperts.pages.elements.CartRow;

import static com.codeborne.selenide.Selenide.$$x;
import static pt.devexperts.pages.BasePage.cartPage;


public class CartPage {

    public ElementsCollection successTableRows() {
        return $$x("//tr[@class='success']").as("Table row of successfully added product to cart");
    }

    public CartRow getFirstTableRow() {
        SelenideElement rawCart = cartPage.successTableRows()
                .first();
        return new CartRow(rawCart);
    }
}
