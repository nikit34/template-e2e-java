package pt.devexperts.properties;

import java.util.Arrays;

public abstract class ConfigPropertiesController {

    public static final String[] SUPPORT_ENVIRONMENT = {
        "dev", "staging", "prod",
    };

    public static void verifyEnvironment(final String environment) {
        if (!Arrays.asList(SUPPORT_ENVIRONMENT).contains(environment)) {
            throw new IllegalArgumentException("Environment [" + environment + "] does not exist in supported: "
                    + Arrays.toString(SUPPORT_ENVIRONMENT));
        }
    }
}
