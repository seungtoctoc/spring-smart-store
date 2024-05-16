package smartstore.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private UserRepository userRepository;

  String signUp(User user) {
    return userRepository.signUp(user);
  }

  Boolean isUniqueId(String id) {
    return userRepository.isUniqueId(id);
  }
}
