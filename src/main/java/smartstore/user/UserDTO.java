package smartstore.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

  private int id;

  @NotBlank(message = "아이디는 필수!")
  @NotEmpty
  private String userId;

  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "이메일 똑바로 ;")
  @NotBlank(message = "이메일은 필수!")
  @Email
  private String email;

  @NotBlank(message = "비밀번호는 필수!")
  private String password;

  @NotBlank(message = "닉네임은 필수!")
  private String nickname;

  @Pattern(regexp = "^(01[016789]-\\d{3,4}-\\d{4})|(0\\d{1,2}-\\d{3,4}-\\d{4})$\n", message = "연락처 똑바로 ;")
  @NotBlank(message = "연락처는 필수!")
  private String contact;

  User makeUser() {
    return new User(id, userId, email, password, nickname, contact);
  }
}
