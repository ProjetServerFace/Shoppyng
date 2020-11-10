package arval.shoppyng.unitTest;

import arval.shoppyng.cart.Repository.UserRepository;
import arval.shoppyng.cart.model.Cart;
import arval.shoppyng.cart.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
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

