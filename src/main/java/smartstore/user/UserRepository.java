package smartstore.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  @PersistenceContext
  EntityManager entityManager;

  User signUp(User user) {
    entityManager.persist(user);

    User savedUser = entityManager.find(User.class, user.getId());
    return savedUser;
  }

  User findUser(Map<String, String> userIdAndPassword) {
    String jpql = "SELECT e FROM User e WHERE e.userId = :userId AND e.password = :password";
    List<User> resultList = entityManager.createQuery(jpql, User.class)
        .setParameter("userId", userIdAndPassword.get("userId"))
        .setParameter("password", userIdAndPassword.get("password"))
        .getResultList();

    return resultList.get(0);
  }

  Boolean isUniqueUserId(String userId) {
    String jpql = "SELECT e FROM User e WHERE e.userId = :userId";
    int count = entityManager.createQuery(jpql, Integer.class)
        .setParameter("userId", userId)
        .getResultList().size();

    if (count > 0) {
      return false;
    }

    return true;
  }

  void initUsers() {

  }
}
