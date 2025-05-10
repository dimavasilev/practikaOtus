package otus;

import com.google.inject.*;
import extensions.UiExtensions;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import pages.MainPage;


@ExtendWith(UiExtensions.class)
public class Training_Test {
  @Inject
  private MainPage mainPage;
  @Test
  @Description("Ntcn 1")
  public void clickCreateTeacherButton() {}

}
