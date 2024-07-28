package pt.devexperts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class MainPage {

    public SelenideElement productTitle(final String nameProduct) {
        return $x("//h4[@class='card-title']/a[text()='" + nameProduct + "']").as("Product title on the card");
    }

    public SelenideElement productPrice(final String nameProduct) {
        return $x("//div[@class='card-block']/h5").as("Product price on the card");
    }
}
