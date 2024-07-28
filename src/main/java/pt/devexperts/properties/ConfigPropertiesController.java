package pt.devexperts.properties;

import java.util.Arrays;

public abstract class ConfigPropertiesController {

    public static final String[] SUPPORT_ENVIRONMENT = {
        "dev", "staging", "prod",
    };

    public static final String[] SUPPORT_TEST_SCOPE = {
        "regress", "smoke"
    };

    public static void verifyEnvironment(final String environment) {
        if (!Arrays.asList(SUPPORT_ENVIRONMENT).contains(environment)) {
            throw new IllegalArgumentException("Environment [" + environment + "] does not exist in supported: "
                    + Arrays.toString(SUPPORT_ENVIRONMENT));
        }
    }

    public static void verifyTestScope(final String testScope) {
        if (!Arrays.asList(SUPPORT_TEST_SCOPE).contains(testScope)) {
            throw new IllegalArgumentException("Test scope [" + testScope + "] does not exist in supported: "
                    + Arrays.toString(SUPPORT_TEST_SCOPE));
        }
    }
}
