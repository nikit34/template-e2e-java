package pt.devexperts.configs;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:environment.properties")
public interface EnvironmentConfig extends Config {
    @DefaultValue("dev")
    @Key("environment.name")
    String environmentName();
}
