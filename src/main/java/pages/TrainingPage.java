package pages;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import annotations.Path;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

@Path("/")
public class TrainingPage extends AbsBasePage<TrainingPage> {

  public TrainingPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//section[./h2[contains(text(), 'Технологии, которые')]]")
  private WebElement technologiesBlock;

  public TrainingPage technologiesBlockShouldBeVisible() {
    assertThat(waiters.waitForElementVisibleByLocator(technologiesBlock))
        .as("Technologies block should be visible")
        .isTrue();
    return this;
  }
}