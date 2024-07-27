package pt.devexperts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public abstract class BaseTest {

    @BeforeAll
    public static void init() {
        WebDriverProvider.init();
    }

    @BeforeEach
    public void setup() {
        WebDriverProvider.setup();
    }
}
