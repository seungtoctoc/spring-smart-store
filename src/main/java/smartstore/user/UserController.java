package smartstore.user;

import jakarta.validation.Valid;
import java.util.InputMismatchException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartstore.user.userDTO.LogInReq;
import smartstore.user.userDTO.LogInRes;
import smartstore.user.userDTO.SignUpReq;
import smartstore.user.userDTO.SignUpRes;
import smartstore.utility.ApiUtils;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

  private UserService userService;

  @PostMapping("/signUp")
  public ApiUtils.ApiResult<Object> signUp(@Valid @RequestBody SignUpReq signUpReq) {
    try {
      SignUpRes signUpRes = userService.signUp(signUpReq);

      if (signUpRes == null) {
        return ApiUtils.error(ApiUtils.makeMap("error", "server error"),
            HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return ApiUtils.success(signUpRes);
    } catch (IllegalStateException e) {
      return ApiUtils.error(ApiUtils.makeMap("error", "id is not unique"),
          HttpStatus.CONFLICT);
    }
  }

  @PostMapping("/login")
  public ApiUtils.ApiResult<Object> login(@Valid @RequestBody LogInReq loginReq) {
    try {
      LogInRes logInRes = userService.login(loginReq);

      if (logInRes == null) {
        return ApiUtils.error("server error", HttpStatus.INTERNAL_SERVER_ERROR);
      }

      return ApiUtils.success(logInRes);
    } catch (IllegalStateException e) {
      return ApiUtils.error(ApiUtils.makeMap("error", "check Id"),
          HttpStatus.BAD_REQUEST);
    } catch (InputMismatchException e) {
      return ApiUtils.error(ApiUtils.makeMap("error", "check Password"),
          HttpStatus.BAD_REQUEST);
    }
  }

//  @DeleteMapping("/user")
//  public ApiUtils.ApiResult<Object> withdraw(@Valid @RequestBody WithdrawReq withdrawReq) {
//
//  }
}

