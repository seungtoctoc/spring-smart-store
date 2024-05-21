package smartstore.user;

import jakarta.validation.Valid;
import java.util.InputMismatchException;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartstore.utility.ApiUtils;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

  private UserService userService;

//  @GetMapping("/datasource")
//  public void makeConnection() {
//    try {
//      userService.makeConnection();
//    } catch (Exception e) {
//      log.error("connect error", e);
//    }
//  }

  @PostMapping("/signUp")
  public ApiUtils.ApiResult<Object> signUp(@Valid @RequestBody UserDTO userDTO) {
    try {
      if (!userService.isUniqueId(userDTO.getUserId())) {
        return ApiUtils.error("id is not unique", HttpStatus.CONFLICT);
      }

      // sign up
      Map<String, String> response = userService.signUp(userDTO);

      // validate
      if (response == null) {
        return ApiUtils.error(ApiUtils.makeMap("error", "server error"),
            HttpStatus.INTERNAL_SERVER_ERROR);
      }

      // return
      return ApiUtils.success(response);
    } catch (IllegalStateException e) {
      return ApiUtils.error(ApiUtils.makeMap("error", "id is not unique"),
          HttpStatus.CONFLICT);
    }
  }

  @PostMapping("/login")
  public ApiUtils.ApiResult<Object> login(@Valid @RequestBody LoginDTO loginDTO) {
    try {
      Map<String, String> response = userService.login(loginDTO);

      if (response == null) {
        return ApiUtils.error("server error", HttpStatus.INTERNAL_SERVER_ERROR);
      }

      return ApiUtils.success(response);
    } catch (IllegalStateException e) {
      return ApiUtils.error(ApiUtils.makeMap("error", "id is not exist"),
          HttpStatus.BAD_REQUEST);
    } catch (InputMismatchException e) {
      return ApiUtils.error(ApiUtils.makeMap("error", "password is not correct"),
          HttpStatus.BAD_REQUEST);
    }

  }

  @PostMapping("/checkId")
  public ResponseEntity<String> isUniqueId(@RequestBody Map<String, String> data) {
    // validate
    Boolean isUnique = userService.isUniqueId(data.get("userId"));

    if (isUnique == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // return
    if (isUnique) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }

  @DeleteMapping("/init")
  public void initUsers() {

  }
}

