package otus;

import com.google.inject.Inject;
import extensions.UiExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CoursesPage;

@ExtendWith(UiExtensions.class)
public class FindCourseByName_Test {

  @Inject
  private CoursesPage coursesPage;

  @Test
  public void clickSearchButton() {
    coursesPage.open();
    coursesPage.clickCreateNewTeach("С++");
    coursesPage.tgLinkShouldBeVisible();
  }
}
