package arval.shoppyng.cart.controller;

import arval.shoppyng.cart.Repository.UserRepository;
import arval.shoppyng.cart.model.User;
import arval.shoppyng.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;


/**
 * Authentication Controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    /**
     * Generate Token From UserName and Password
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/signin")
    public ResponseEntity<String> signin(String username, @RequestParam(required = false) String password) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtTokenProvider.createToken(username);

            return ok(token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    /**
     * Create User From UserName and Password
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(String username, String password) {
        User user = new User(System.currentTimeMillis(), username, passwordEncoder.encode(password));
        user = userRepository.createUser(user);
        return ok(user);
    }

}

