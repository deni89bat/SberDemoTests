package sberJazz.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "system:env", "file:src/test/resources/config.properties"})
public interface UIProps extends Config {

    @Key("BASE_URL")
    String baseURL();

    @Key("PAGE_LOAD_TIMEOUT")
    int pageLoadTimeout();

    @Key("IMPLICIT_WAIT")
    int implicitWait();

    @Key("SELENOID_URL")
    String selenoidUrl();

}

