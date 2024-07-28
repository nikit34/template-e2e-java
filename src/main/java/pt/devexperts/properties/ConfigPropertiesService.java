package pt.devexperts.properties;

import org.aeonbits.owner.ConfigFactory;
import pt.devexperts.configs.EnvironmentConfig;
import pt.devexperts.configs.TestScopeConfig;

import java.util.Optional;
import java.util.Properties;

import static pt.devexperts.properties.ConfigPropertiesController.verifyEnvironment;
import static pt.devexperts.properties.ConfigPropertiesController.verifyTestScope;


public abstract class ConfigPropertiesService {

    private static final String ENVIRONMENT_PROPERTY = "environment";
    private static final String TEST_LAYERS_PROPERTY = "test.layers";

    private static final EnvironmentConfig ENVIRONMENT_CONFIG =
            ConfigFactory.create(EnvironmentConfig.class, System.getProperties());
    private static final TestScopeConfig TEST_SCOPE_CONFIG =
            ConfigFactory.create(TestScopeConfig.class, System.getProperties());

    public static Properties getProperties() {
        final Properties properties = System.getProperties();

        final String environment = Optional.ofNullable(properties.getProperty(ENVIRONMENT_PROPERTY))
                .orElse(ENVIRONMENT_CONFIG.environmentName());
        verifyEnvironment(environment);
        properties.put(ENVIRONMENT_PROPERTY, environment);

        final String testLayers = Optional.ofNullable(properties.getProperty(TEST_LAYERS_PROPERTY))
                .orElse(TEST_SCOPE_CONFIG.testLayers());
        verifyTestScope(testLayers);
        properties.put(TEST_LAYERS_PROPERTY, testLayers);

        return properties;
    }
}
