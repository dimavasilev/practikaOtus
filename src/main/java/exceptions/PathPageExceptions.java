package exceptions;

public class PathPageExceptions extends RuntimeException {
  public PathPageExceptions() {
    super("Path on page not found");
  }
}
