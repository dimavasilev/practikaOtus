package otus;

import com.google.inject.Inject;
import extensions.UiExtensions;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CoursesPage;

@ExtendWith(UiExtensions.class)
public class FindCourseByName_Test {

  @Inject
  private CoursesPage coursesPage;

  @Test()
  @Story("Ntcn")
  @Description("Тест 1")
  public void clickSearchButton() {
    coursesPage.open();
    coursesPage.clickCreateNewTeach("C++7");
    coursesPage.tgLinkShouldBeVisible();
  }
}
