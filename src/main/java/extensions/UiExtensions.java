package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import commons.AbsCommons;
import modules.GuiceModule;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class UiExtensions implements BeforeEachCallback, AfterEachCallback {

  private Injector injector;

  @Override
  public void beforeEach(ExtensionContext context) {
    injector = Guice.createInjector(new GuiceModule());

    AbsCommons.injector = injector;
    injector.injectMembers(context.getTestInstance().get());
  }

  @Override
  public void afterEach(ExtensionContext context) {
    WebDriver driver = injector.getInstance(WebDriver.class);
    if (driver != null) {
      driver.quit();
    }
  }
}
