package config;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.browser = ConfigHelper.getSearchBrowser();
        Configuration.browserVersion = ConfigHelper.getSearchVersion();

        if (System.getProperty("remote_driver") != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = ConfigHelper.getSearchRemote();
        }
    }

        @AfterEach
        public void afterEach() {
            attachScreenshot("Last screenshot");
            attachPageSource();
            attachAsText("Browser console logs", getConsoleLogs());
            if(System.getProperty("video_storage") != null)
            attachVideo();
            closeWebDriver();
        }
    }