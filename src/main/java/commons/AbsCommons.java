package commons;

import com.google.inject.Inject;
import commons.waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsCommons {

  @Inject
  protected WebDriver driver;

  protected Waiters waiters;


  public AbsCommons(WebDriver driver) {
    this.driver = driver;
    this.waiters = new Waiters(this.driver);


    PageFactory.initElements(this.driver, this);
  }
}
