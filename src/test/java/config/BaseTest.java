package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        setSelenideConfiguration();
    }

    @AfterEach
    public void clean() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    private static void setSelenideConfiguration() {
        Configuration.startMaximized = true;
    }
}