package smartstore.utility;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiUtils<T> {

  public static <T> ApiResult<T> success(T data) {
    return new ApiResult<>(true, data, null);
  }

  public static <T> ApiResult<T> error(T message, HttpStatus httpStatus) {
    return new ApiResult<>(false, null, new ApiError<>(message, httpStatus));
  }

  @Getter
  @AllArgsConstructor
  public static class ApiResult<T> {

    boolean success;
    T response;
    ApiError<T> error;
  }

  @Getter
  @AllArgsConstructor
  static class ApiError<T> {

    T message;
    HttpStatus httpStatus;
  }

  public static Map<String, String> makeMap(String key, String val) {
    Map<String, String> resp = new HashMap<>();
    resp.put(key, val);

    return resp;
  }


}
