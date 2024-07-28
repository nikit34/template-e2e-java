package pt.devexperts.testdata;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:testdata/elements.properties")
public interface ElementsConfig extends Config {
    @Key("btn.addToCart")
    String btnAddToCart();

    @Key("btn.deleteFromCart")
    String btnDeleteFromCart();
}
