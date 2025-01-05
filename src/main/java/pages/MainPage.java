package pages;

import annotations.Path;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Path("/")
public class MainPage extends AbsBasePage<MainPage> {

  @Inject
  private TeachPage teachPage;


  @FindBy(css = "section a[href='/teach']")
  private WebElement createNewTeach;

  public TeachPage clickCreateNewTeach() {
    createNewTeach.click();
    return this.teachPage;
  }
}

