package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"
})
public interface WebConfig extends Config {
    @Key("search.browser")
    String searchBrowser();

    @Key("search.version")
    String searchVersion();

    @Key("search.remote")
    String searchRemote();
}
