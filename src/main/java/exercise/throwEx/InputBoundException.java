package exercise.throwEx;

public class InputBoundException extends Exception {

  private String message;

  public InputBoundException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
