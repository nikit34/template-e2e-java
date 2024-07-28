package pt.devexperts;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pt.devexperts.configs.testdata.ProductsConfig;
import pt.devexperts.labels.TestLayerCondition;

import static java.lang.System.getProperties;


@ExtendWith(TestLayerCondition.class)
public abstract class BaseTest {
    protected static final ProductsConfig PRODUCTS_CONFIG = ConfigFactory.create(ProductsConfig.class, getProperties());

    @BeforeAll
    public static void init() {
        WebDriverProvider.init();
    }

    @BeforeEach
    public void setup() {
        WebDriverProvider.setup();
    }

    @AfterEach
    public void tearDown() {
        WebDriverProvider.tearDown();
    }
}
