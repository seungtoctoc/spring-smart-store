package smartstore.user;

import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import smartstore.user.userDTO.LogInReq;
import smartstore.user.userDTO.SignUpReq;

@Service
@AllArgsConstructor
public class UserService {

  private UserJPARepository userJPARepository;

  @Transactional
  Map<String, String> signUp(SignUpReq signUpReq) {
    Optional<User> foundUser = userJPARepository.findByUserId(signUpReq.getUserId());

    if (foundUser.isEmpty()) {
      throw new IllegalStateException();
    }

    User createdUser = userJPARepository.save(signUpReq.makeUser());

    Map<String, String> response = new HashMap<>();

    response.put("userId", createdUser.getUserId());
    response.put("nickname", createdUser.getNickname());

    return response;
  }

  Map<String, String> login(LogInReq loginReq) {
    Optional<User> foundUser = userJPARepository.findByUserId(loginReq.getUserId());

    if (foundUser.isEmpty()) {
      throw new IllegalStateException();
    }

    if (!foundUser.get().getPassword().equals(loginReq.getPassword())) {
      throw new InputMismatchException();
    }

    Map<String, String> response = new HashMap<>();
    response.put("userId", foundUser.get().getUserId());
    response.put("nickname", foundUser.get().getNickname());

    return response;
  }

  Optional<User> findByUserId(String userId) {
    return userJPARepository.findByUserId(userId);
  }
}
