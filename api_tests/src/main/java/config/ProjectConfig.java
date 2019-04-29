package config;

import org.aeonbits.owner.Config;

@Config.Sources({ "classpath:config.properties" })
public interface ProjectConfig extends Config {

    @Key("apiPath")
    String apiPath();

    @Key("apiToken")
    String apiToken();

}
