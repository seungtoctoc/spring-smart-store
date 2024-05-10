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
  private static Logger logger = LoggerFactory.getLogger(UserController.class);

  @PostMapping("/signup")
  public ResponseEntity<Map<String, String>> signUp(@RequestBody User user) {
    logger.info(user.getNickname());

    String createdNickname = userService.signUp(user);

    if (createdNickname == null){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    Map<String, String> responseBody = new HashMap<>();
    responseBody.put("nickname", createdNickname);

    return new ResponseEntity<>(responseBody, HttpStatus.OK);
  }

}
