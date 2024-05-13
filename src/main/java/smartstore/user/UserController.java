package smartstore.user;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
  private UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<Map<String, String>> signUp(@RequestBody User user) {
    // validate id
    String id = user.getId();
    ResponseEntity validateResp = isUniqueId(id);

    if (validateResp.getStatusCode() != HttpStatus.OK) {
      return  validateResp;
    }

    // sign up
    String createdNickname = userService.signUp(user);


    // validate
    if (createdNickname == null){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // return
    Map<String, String> responseBody = new HashMap<>();
    responseBody.put("nickname", createdNickname);
    return new ResponseEntity<>(responseBody, HttpStatus.OK);
  }

  @PostMapping("/checkid")
  public ResponseEntity isUniqueId(@RequestBody String id) {
    // validate
    Boolean isUnique = userService.isUniqueId(id);

    if (isUnique == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // return
    if (isUnique) {
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }
}
