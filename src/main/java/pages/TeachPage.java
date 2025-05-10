package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import annotations.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Path("/teach")
public class TeachPage extends AbsBasePage<TeachPage> {

  public TeachPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//section[./h2[contains(text(), 'Технологии, которые')]]")
  private WebElement technologiesBlock;

  public TeachPage technologiesBlockShouldBeVisible() {
    assertThat(waiters.waitForElementVisibleByLocator(technologiesBlock))
        .as("Technologies block should be visible")
        .isTrue();
    return this;
  }
}

