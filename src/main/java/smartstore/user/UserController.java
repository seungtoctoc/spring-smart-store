package smartstore.user;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartstore.user.MyException.MyError;

@RestController
@AllArgsConstructor
public class UserController {

  private UserService userService;

  @PostMapping("/signUp")
  public MyException signUp(@RequestBody User user) {
    // validate id
    String id = user.getId();
    Boolean isUniqueId = userService.isUniqueId(id);

    if (isUniqueId == null) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      return new MyException<>(false, null,
          new MyError("server_error", HttpStatus.INTERNAL_SERVER_ERROR));
    }
    if (!isUniqueId) {
//      return new ResponseEntity<>(HttpStatus.CONFLICT);
      return new MyException<>(false, null,
          new MyError("id is not unique", HttpStatus.CONFLICT));
    }

    // sign up
    String createdNickname = userService.signUp(user);

    // validate
    if (createdNickname == null) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      return new MyException<>(false, null,
          new MyError("server_error", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    // return
    Map<String, String> responseBody = new HashMap<>();
    responseBody.put("nickname", createdNickname);
//    return new ResponseEntity<>(responseBody, HttpStatus.OK);
    return new MyException<>(true, responseBody, null);
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
