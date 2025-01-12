package pages;

import annotations.Path;
import annotations.UrlData;
import org.openqa.selenium.WebDriver;


@UrlData("/lessons/$1")
public class LessonPage extends AbsBasePage<LessonPage> {

  public LessonPage(WebDriver driver) {
    super(driver);
  }



}
