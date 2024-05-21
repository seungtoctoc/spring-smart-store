package smartstore.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class LoginDTO {

  @NotBlank(message = "아이디는 필수!")
  @NotEmpty
  private String userId;

  @NotBlank(message = "비밀번호는 필수!")
  @NotEmpty
  private String password;
}
