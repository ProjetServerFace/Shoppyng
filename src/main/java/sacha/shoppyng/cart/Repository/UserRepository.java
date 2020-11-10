package sacha.shoppyng.cart.Repository;

import sacha.shoppyng.cart.model.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User Repository.
 */
@Getter
@Repository
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    /**
     * Create User
     * @param user
     * @return User
     */
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    /**
     * find user by User name
     * @param username
     * @return
     */
    public Optional<User> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
