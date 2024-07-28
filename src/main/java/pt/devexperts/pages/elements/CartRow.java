package pt.devexperts.pages.elements;

import com.codeborne.selenide.SelenideElement;
import pt.devexperts.SelenideBlock;


public class CartRow extends SelenideBlock {

    public CartRow(final SelenideElement origin) {
        super(origin);
    }

    public SelenideElement title() {
        return this.$x("td[2]").as("Title in cart row");
    }

    public SelenideElement price() {
        return this.$x("td[3]").as("Price in cart row");
    }

    public SelenideElement removeBtn() {
        return this.$x("td[4]/a").as("Button for delete product from cart");
    }
}
