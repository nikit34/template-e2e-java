package pt.devexperts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class ProductPage {
    public SelenideElement productTitle() {
        return $x("//div[contains(@class, 'product-content')]//h2[@class='name']").as("Product title on the product page");
    }

    public SelenideElement productPrice() {
        return $x("//h3[@class='price-container']").as("Product price on the product page");
    }

    public SelenideElement addToCartBtn() {
        return $x("//a[contains(@class, 'btn-success')]").as("Product button for add to cart on the product page");
    }
}
