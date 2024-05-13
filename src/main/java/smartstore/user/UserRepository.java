package smartstore.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private Map<String, User> userTable = new HashMap<>();

  String signUp(User user) {
    userTable.put(user.getId(), user);

    User createdUser = userTable.get(user.getId());
    return createdUser.getNickname();
  }

  Boolean isUniqueId(String id) {
    for (User user : userTable.values()) {
      if (id.equals(user.getId())) {
        return false;
      }
    }
    return true;
  }
}
