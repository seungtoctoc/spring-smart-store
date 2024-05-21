package smartstore.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import smartstore.utility.ApiUtils;

@RestControllerAdvice
public class GlobalException {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiUtils.ApiResult<Map<String, String>> handleValidException(
      MethodArgumentNotValidException errors) {
    Map<String, String> errorMessages = new HashMap<>();
    for (FieldError error : errors.getFieldErrors()) {
      errorMessages.put(error.getField(), error.getDefaultMessage());
    }

    return ApiUtils.error(errorMessages, HttpStatus.BAD_REQUEST);
  }
}
