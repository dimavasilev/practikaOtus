package otus;

import com.google.inject.*;
import extensions.UiExtensions;
import org.junit.jupiter.api.extension.*;
import pages.MainPage;


@ExtendWith(UiExtensions.class)
public class Training_Test {
  @Inject
  private MainPage mainPage;

}
