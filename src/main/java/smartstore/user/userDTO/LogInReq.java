package smartstore.user.userDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LogInReq {

  @NotBlank(message = "아이디는 필수!")
  private String userId;

  @NotBlank(message = "비밀번호는 필수!")
  private String password;
}
