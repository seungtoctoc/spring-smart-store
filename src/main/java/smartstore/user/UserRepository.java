package smartstore.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  private Map<Integer, User> userTable = new HashMap<>();
  private int end = 0;

  User signUp(User user) {
    userTable.put(end, user);
    return userTable.get(end++);
  }
}
