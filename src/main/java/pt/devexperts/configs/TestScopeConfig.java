package pt.devexperts.configs;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:test_scope.properties")
public interface TestScopeConfig extends Config {
    @DefaultValue("regress")
    @Key("test.layers")
    String testLayers();
}
