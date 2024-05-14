package smartstore.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class MyException<T> {

  boolean success;
  T data;
  MyError error;

//  MyException(boolean success, T data, String message, HttpStatus statusCode) {
//    this.success = success;
//    this.data = data;
//    this.error = new MyError(message, statusCode);
//  }

  @Getter
  @Setter
  @AllArgsConstructor
  public static class MyError {

    String message;
    HttpStatus statusCode;

//    MyError(String message, HttpStatus statusCode) {
//      this.message = message;
//      this.statusCode = statusCode;
//    }
  }
}
