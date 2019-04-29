package config;

import org.aeonbits.owner.Config;

@Config.Sources({ "classpath:config.properties" })
public interface ProjectConfig extends Config {

    @Key("API_PATH")
    String apiPath();

    @Key("API_TOKEN")
    String apiToken();

}
