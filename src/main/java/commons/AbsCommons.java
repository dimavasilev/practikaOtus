package commons;

import com.google.inject.Inject;
import com.google.inject.Injector;
import commons.waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsCommons {

  @Inject
  protected WebDriver driver;

  protected Waiters waiters;

  public static Injector injector = null;

  public AbsCommons() {
    this.waiters = new Waiters(this.driver);

    if (injector != null) {
      AbsCommons.injector.injectMembers(this);
    }

    PageFactory.initElements(this.driver, this);
  }
}
