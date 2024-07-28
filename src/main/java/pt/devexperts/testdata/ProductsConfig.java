package pt.devexperts.testdata;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testdata/products.properties")
public interface ProductsConfig extends Config {
    @Key("product.title")
    String productTitle();

    @Key("product.price")
    String productPrice();
}
