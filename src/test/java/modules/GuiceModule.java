package modules;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

public class GuiceModule extends AbstractModule {

    private WebDriver driver;

    public GuiceModule(WebDriver driver) {
        this.driver = driver;
    }
}
