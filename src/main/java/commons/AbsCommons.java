package commons;

import commons.waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsCommons {

    protected WebDriver driver;

    protected Waiters waiters;

    public AbsCommons(WebDriver driver) {
       this.driver = driver;
       this.waiters = new Waiters(driver);

       PageFactory.initElements(driver, this);
    }
}
