package smartstore.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
  private int id;
  private String email;
  private String password;
  private String nickname;
  private String contact;
}
