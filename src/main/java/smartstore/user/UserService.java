package smartstore.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import java.util.HashMap;
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
//    if (!userRepository.isUniqueUserId(userDTO.getUserId())) {
//      throw new IllegalStateException("id is not unique");
//    }

    User newUser = userDTO.makeUser();
    User savedUser = userRepository.signUp(newUser);

    Map<String, String> response = new HashMap<>();
    response.put("id", savedUser.getId().toString());
    response.put("userId", savedUser.getUserId());

    return response;
  }

  Map<String, String> login(LoginDTO loginDTO) {
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, String> convertedLoginDTO = objectMapper.convertValue(loginDTO, Map.class);

    User foundUser = userRepository.findUser(convertedLoginDTO);

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
