package smartstore.user;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  public ResponseEntity<User> signUp(@RequestBody User user) {
    logger.info(user.getNickname());

    return null;
  }

}
