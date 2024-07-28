package pt.devexperts.properties;

import org.aeonbits.owner.ConfigFactory;
import pt.devexperts.configs.EnvironmentConfig;

import java.util.Optional;
import java.util.Properties;

import static pt.devexperts.properties.ConfigPropertiesController.verifyEnvironment;


public abstract class ConfigPropertiesService {

    private static final String ENVIRONMENT_PROPERTY = "environment";

    private static final EnvironmentConfig ENVIRONMENT_CONFIG =
            ConfigFactory.create(EnvironmentConfig.class, System.getProperties());

    public static Properties getProperties() {
        final Properties properties = System.getProperties();
        final String environment = Optional.ofNullable(properties.getProperty(ENVIRONMENT_PROPERTY))
                .orElse(ENVIRONMENT_CONFIG.environmentName());
        verifyEnvironment(environment);
        properties.put(ENVIRONMENT_PROPERTY, environment);
        return properties;
    }
}
