package pages;

import commons.AbsCommons;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage<T> extends AbsCommons {

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public T open(){
        return (T)this;
    }

}
