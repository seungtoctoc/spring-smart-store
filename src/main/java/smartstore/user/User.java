package smartstore.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartstore.user.userDTO.LogInRes;
import smartstore.user.userDTO.SignUpRes;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

  @Id
  private Integer id;
  private String userId;
  private String email;
  private String password;
  private String nickname;
  private String contact;

  SignUpRes makeSignUpRes() {
    return new SignUpRes(userId, nickname);
  }

  LogInRes makeLogInRes() {
    return new LogInRes(userId, nickname);
  }
}
