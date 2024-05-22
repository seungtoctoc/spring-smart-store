package smartstore.user.userDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogInRes {

  private String userId;
  private String nickname;
}
