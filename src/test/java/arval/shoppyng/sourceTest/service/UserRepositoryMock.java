package arval.shoppyng.sourceTest.service;

import arval.shoppyng.cart.Repository.UserRepository;
import arval.shoppyng.cart.model.User;
import lombok.Getter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class UserRepositoryMock extends UserRepository {

    public Optional<User> findByUsername(String username) {
        User user = new User(1L, "userTest", "");
        return Optional.of(user);
    }
}
