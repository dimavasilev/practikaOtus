package commons.waiters;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waiters {

  private final WebDriverWait webDriverWait;

  public Waiters(WebDriver driver) {

    this.webDriverWait = new WebDriverWait(
        driver,
        Duration.ofSeconds(Integer.parseInt(System.getProperty("webdriver.waiter.timeout")))
    );
  }

  public boolean waitForCondition(ExpectedCondition condition) {
    try {
      webDriverWait.until(condition);
      return true;
    } catch (TimeoutException ignored) {
      return false;
    }
  }

  public boolean waitForElementPresentByLocator(By locator) {
    return this.waitForCondition(ExpectedConditions.presenceOfElementLocated(locator));
  }


  public boolean waitForElementVisibleByLocator(WebElement element) {
    return this.waitForCondition(ExpectedConditions.visibilityOf(element));
  }

}
