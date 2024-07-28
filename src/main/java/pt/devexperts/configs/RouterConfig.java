package pt.devexperts.configs;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:${environment}/router.properties", "system:env"})
public interface RouterConfig extends Config {
    @Key("base.url")
    String baseUrl();
}