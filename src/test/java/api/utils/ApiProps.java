package api.utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ApiProps extends Config {
    @Key("api.base.url")
    String baseUrl();
}