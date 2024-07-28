package pt.devexperts.testdata;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testdata/products.properties")
public interface ProductsConfig extends Config {
    @Key("title")
    String title();

    @Key("price")
    String price();

    @Key("price.currency")
    String priceCurrency();
}
