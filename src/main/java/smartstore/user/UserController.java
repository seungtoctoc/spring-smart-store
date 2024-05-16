package smartstore.user;

import static smartstore.utility.ApiUtils.error;
import static smartstore.utility.ApiUtils.success;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartstore.utility.ApiUtils.ApiResult;

@RestController
@AllArgsConstructor
public class UserController {

  private UserService userService;

  @PostMapping("/signUp")
  public ApiResult signUp(@RequestBody User user) {
    // validate id
    String id = user.getId();
    Boolean isUniqueId = userService.isUniqueId(id);

    if (isUniqueId == null) {
      return error("server_error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if (!isUniqueId) {
      return error("id_is_not_unique", HttpStatus.CONFLICT);
    }

    // sign up
    String createdNickname = userService.signUp(user);

    // validate
    if (createdNickname == null) {
      return error("server_error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // return
    Map<String, String> responseBody = new HashMap<>();
    responseBody.put("nickname", createdNickname);
    return success(responseBody);
  }

  @PostMapping("/checkId")
  public ResponseEntity isUniqueId(@RequestBody Map<String, String> data) {
    // validate
    Boolean isUnique = userService.isUniqueId(data.get("id"));

    if (isUnique == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    System.out.println("is Unique: " + isUnique);

    // return
    if (isUnique) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }
}
