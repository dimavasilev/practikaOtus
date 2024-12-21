package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class WebDriverFactory {

    private String browserNane = System.getProperty("browser.name").toLowerCase(Locale.ROOT);

    public WebDriver create() {
        switch (browserNane) {
            case "chrome":{
                WebDriverManager.chromedriver().setup();
            }
        }
        return null;
    }
}
