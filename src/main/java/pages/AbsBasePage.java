package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import annotations.Path;
import annotations.UrlData;
import commons.AbsCommons;
import exceptions.PathPageExceptions;
import exceptions.UrlDataExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbsBasePage<T> extends AbsCommons {

  private String baseUrl = System.getProperty("base.url");

  public AbsBasePage(WebDriver driver) {
    super(driver);
    baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
  }

  @FindBy(tagName = "h1")
  private WebElement header;


  public T pageHeaderShouldBeSameAs(String expectedHeader) {
    assertThat(header.getText())
        .as("Header should be {}", expectedHeader)
        .isEqualTo(expectedHeader);
    return (T) this;
  }

  private String getUrlTemplate() {
    Class clazz = this.getClass();
    if (clazz.getAnnotation(UrlData.class) != null) {
      UrlData urlData = (UrlData) clazz.getDeclaredAnnotation(UrlData.class);
      return urlData.value();
    }
    throw new UrlDataExceptions();
  }


  private String getPath() {
    Class<? extends AbsBasePage> clazz = this.getClass();
    if (clazz.isAnnotationPresent(Path.class)) {
      Path path = clazz.getAnnotation(Path.class);
      return path.value().startsWith("/") ? path.value() : "/" + path.value();
    }
    return "";
  }

  public T open() {
    String path = getPath();
    if(path.isEmpty()){
      throw new PathPageExceptions();
    }

    driver.get(baseUrl + path);
    return (T) this;
  }

  public T open(String... params) {
    String path = getPath();
    String url = getUrlTemplate();

    for (int i = 0; i < params.length; i++) {
      url = url.replace("$" + (i + 1), params[i]);
    }

    if(!path.isEmpty()){
      url = path + url;

    }
    driver.get(baseUrl + url);
    return (T) this;
  }
}
