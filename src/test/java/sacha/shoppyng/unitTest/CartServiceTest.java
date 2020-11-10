package sacha.shoppyng.unitTest;

import sacha.shoppyng.cart.Repository.CartRepository;
import sacha.shoppyng.cart.model.Cart;
import sacha.shoppyng.cart.model.User;
import sacha.shoppyng.cart.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    @Test(expected = RuntimeException.class)
    public void shouldCreateCartExist() {

        Mockito.when(cartRepository.findCartByUserId(any())).thenReturn(Optional.of(new Cart()));
        User user = new User();
        cartService.createCart(user);
    }

    @Test(expected = RuntimeException.class)
    public void shouldDeleteCartExist() {
        Mockito.when(cartRepository.findCartByUserId(any())).thenReturn(Optional.empty());
        cartService.deleteCart(1l);
    }

}
