package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.CoursesPage;
import pages.MainPage;
import pages.TeachPage;

public class GuiceModule extends AbstractModule {

  private WebDriver driver;

  public GuiceModule() {
    driver = new WebDriverFactory().create();
  }

  @Provides
  private WebDriver getDriver() {
    return this.driver;
  }

  @Provides
  @Singleton
  public MainPage getMainPage() {
    return new MainPage(driver);
  }

  @Provides
  @Singleton
  public CoursesPage getCoursesPage() {
    return new CoursesPage(driver);
  }

  @Provides
  @Singleton
  public TeachPage getTechPage() {
    return new TeachPage(driver);
  }

}
