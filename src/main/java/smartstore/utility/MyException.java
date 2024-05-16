package smartstore.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class MyException<T> {

  boolean success;
  T data;
}

@Getter
@AllArgsConstructor
class MyError {

  String message;
  HttpStatus statusCode;
}

class Success {

}