package smartstore.user;

import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private UserRepository userRepository;

  //  public void makeConnection() {
//    userRepository.makeConnection();
//  }
//
  @Transactional
  Map<String, String> signUp(UserDTO userDTO) {
    if (!userRepository.isUniqueUserId(userDTO.getUserId())) {
      throw new IllegalStateException("id is not unique");
    }

    User newUser = userDTO.makeUser();
    userRepository.saveUser(newUser);

    User savedUser = userRepository.findUserWithUserId(userDTO.getUserId());

    Map<String, String> response = new HashMap<>();
    if (savedUser != null) {
      response.put("id", savedUser.getId().toString());
      response.put("userId", savedUser.getUserId());
    }

    return response;
  }

  Map<String, String> login(LoginDTO loginDTO) {
    if (userRepository.isUniqueUserId(loginDTO.getUserId())) {
      throw new IllegalStateException();
    }

    User foundUser = userRepository.findUserWithUserId(loginDTO.getUserId());

    if (!foundUser.getPassword().equals(loginDTO.getPassword())) {
      throw new InputMismatchException();
    }

    Map<String, String> response = new HashMap<>();
    response.put("id", foundUser.getUserId());
    response.put("nickname", foundUser.getNickname());
    response.put("contact", foundUser.getContact());

    return response;
  }

  Boolean isUniqueId(String userId) {
    return userRepository.isUniqueUserId(userId);
  }
}
