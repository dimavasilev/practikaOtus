package pages;

import annotations.Path;
import org.openqa.selenium.WebDriver;

@Path("/lessons/{}")
public class LessonPage extends AbsBasePage<LessonPage> {

  public LessonPage(WebDriver driver) {
    super(driver);
  }

}
