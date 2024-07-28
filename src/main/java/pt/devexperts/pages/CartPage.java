package pt.devexperts.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;


public class CartPage {
    public ElementsCollection successTableRows() {
        return $$x("//tr[@class='success']").as("Table row of successfully added product to cart");
    }
}
