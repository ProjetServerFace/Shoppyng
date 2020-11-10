package sacha.shoppyng.sourceTest.service;

import sacha.shoppyng.cart.Repository.UserRepository;
import sacha.shoppyng.cart.model.User;
import lombok.Getter;

import java.util.Optional;

@Getter
public class UserRepositoryMock extends UserRepository {

    public Optional<User> findByUsername(String username) {
        User user = new User(1L, "userTest", "");
        return Optional.of(user);
    }
}
