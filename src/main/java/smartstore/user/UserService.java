package smartstore.user;

import jakarta.transaction.Transactional;
import java.util.InputMismatchException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import smartstore.user.userDTO.LogInReq;
import smartstore.user.userDTO.LogInRes;
import smartstore.user.userDTO.SignUpReq;
import smartstore.user.userDTO.SignUpRes;

@Service
@AllArgsConstructor
public class UserService {

  private UserJPARepository userJPARepository;

  @Transactional
  SignUpRes signUp(SignUpReq signUpReq) {
    Optional<User> foundUser = userJPARepository.findByUserId(signUpReq.getUserId());

    if (foundUser.isPresent()) {
      throw new IllegalStateException();
    }

    User savedUser = userJPARepository.save(signUpReq.makeUser());

    return savedUser.makeSignUpRes();
  }

  LogInRes login(LogInReq loginReq) {
    Optional<User> foundUser = findByIdAndPw(loginReq.getUserId(), loginReq.getPassword());
    
    return foundUser.get().makeLogInRes();
  }

//  Optional<User> withdraw(WithdrawReq withdrawReq) {
//    Optional<User> foundUser = findByIdAndPw(withdrawReq.getUserId(), withdrawReq.getPassword());
//
//    // 여기부터 시작
//  }

  Optional<User> findByIdAndPw(String userId, String password) {
    Optional<User> foundUser = userJPARepository.findByUserId(userId);

    if (foundUser.isEmpty()) {
      throw new IllegalStateException();
    }

    if (!foundUser.get().getPassword().equals(password)) {
      throw new InputMismatchException();
    }

    return foundUser;
  }


}


