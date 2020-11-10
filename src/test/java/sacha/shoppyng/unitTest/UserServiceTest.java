package sacha.shoppyng.unitTest;

import sacha.shoppyng.cart.Repository.UserRepository;
import sacha.shoppyng.cart.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test(expected = UsernameNotFoundException.class)
    public void shouldThrowUserHaveCart() {
        Mockito.when(userRepository.findByUsername(any())).thenReturn(Optional.empty());
        userService.loadUserByUsername(null);
    }


}

