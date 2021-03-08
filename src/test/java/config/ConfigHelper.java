package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getSearchBrowser() {
        return getConfig().searchBrowser();
    }

    public static String getSearchVersion() {
        return getConfig().searchVersion();
    }

    public static String getSearchRemote() {
        return getConfig().searchRemote();
    }

    private static WebConfig getConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}
