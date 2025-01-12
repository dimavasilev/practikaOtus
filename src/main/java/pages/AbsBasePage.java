package pages;

import annotations.Path;
import commons.AbsCommons;
import exceptions.PathPageExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AbsBasePage<T> extends AbsCommons {

  private String baseUrl = System.getProperty("base.url");

  public AbsBasePage(WebDriver driver ) {
    super(driver);
  }

  @FindBy(tagName = "h1")
  private WebElement header;


  public T pageHeaderShouldBeSameAs(String expectedHeader) {
    assertThat(header.getText())
        .as("Header should be {}", expectedHeader)
        .isEqualTo(expectedHeader);
    return (T) this;
  }


  private String getPath() {
    Class<? extends AbsBasePage> clazz = this.getClass();
    if (clazz.isAnnotationPresent(Path.class)) {
      Path path = clazz.getAnnotation(Path.class);
      return path.value().startsWith("/") ? path.value() : "/" + path.value();
    }
    throw new PathPageExceptions();
  }

  public T open() {
    baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
    driver.get(baseUrl + getPath());
    return (T) this;
  }

}
