package smartstore.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  @PersistenceContext
  EntityManager entityManager;

  void saveUser(User user) {
    // persist로 넣어야 하는데, 겹칠 경우 그냥 넣도록 (for 테스트)
    entityManager.merge(user);
  }

  User findUserWithUserId(String userId) {
    String jpql = "SELECT e FROM User e WHERE e.userId = :userId";

    User foundUser = entityManager.createQuery(jpql, User.class)
        .setParameter("userId", userId)
        .getSingleResult();

    return foundUser;
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
