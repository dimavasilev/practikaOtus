package pages;

import annotations.Path;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Path("/catalog/courses")
public class CoursesPage extends AbsBasePage<CoursesPage> {

  @FindBy(css = "input[type='search']")
  private WebElement searchInput;

  @FindBy(xpath = "//div[contains(text(), 'Группа')]")
  private WebElement tgLink;

  public CoursesPage clickCreateNewTeach(String searchText) {
    searchInput.sendKeys("searchText");
    return this;
  }

  public CoursesPage tgLinkShouldBeVisible() {
    assertThat(waiters.waitForElementVisibleByLocator(tgLink))
        .as("TgLink be visible")
        .isTrue();
    return this;
  }

}


