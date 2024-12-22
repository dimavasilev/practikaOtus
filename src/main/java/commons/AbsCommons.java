package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsCommons {

    protected WebDriver driver;

    public AbsCommons(WebDriver driver) {
       this.driver = driver;

       PageFactory.initElements(driver, this);
    }
}
