package arval.shoppyng.cart.service;

import arval.shoppyng.cart.Repository.UserRepository;
import arval.shoppyng.cart.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User Service
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * User Loading
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }


    /**
     * get connected User
     * @return User
     * @throws UsernameNotFoundException
     */
    public User getUserConnected() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user;
        if (principal instanceof User) {
            user = (User) principal;
        } else {
            UserDetails userDetails = (UserDetails) principal;
            user = (User) this.loadUserByUsername(userDetails.getUsername());
        }
        return user;
    }
}

