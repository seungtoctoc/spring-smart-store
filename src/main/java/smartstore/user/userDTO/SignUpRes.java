package smartstore.user.userDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRes {

  private int id;
  private String userId;
  private String nickname;
}
