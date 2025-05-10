package otus;

import com.google.inject.Inject;
import extensions.UiExtensions;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;

@ExtendWith(UiExtensions.class)
public class TecherBlock_Test {

  @Inject
  private MainPage mainPage;

  @Test
  @Description("Тест ")
    public void clickCreateTeacherButton() {
    mainPage
        .open()
        .clickCreateNewTeach()
        .pageHeaderShouldBeSameAs("Делись знаниями")
        .technologiesBlockShouldBeVisible();
  }
}