package exceptions;

public class UrlDataExceptions extends RuntimeException {
  public UrlDataExceptions() {
    super("URL data annotation doesn't exist on page");
  }
}
