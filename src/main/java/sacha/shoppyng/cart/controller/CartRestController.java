package sacha.shoppyng.cart.controller;

import sacha.shoppyng.cart.model.Cart;
import sacha.shoppyng.cart.model.User;
import sacha.shoppyng.cart.service.CartService;
import sacha.shoppyng.cart.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Cart Controller.
 */
@RestController
@RequestMapping("/api/cart")
public class CartRestController {


    private final CartService cartService;

    private final UserService userService;

    public CartRestController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    /**
     * Create Cart
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Cart> createCart() throws URISyntaxException {
        User user = userService.getUserConnected();
        Cart cartCreated = cartService.createCart(user);
        return ResponseEntity.created(new URI("/api/cart")).body(cartCreated);
    }

    /**
     * Detate Cart
     * @return
     */
    @DeleteMapping("")
    public ResponseEntity<String> deleteCart() {
        User user = userService.getUserConnected();
        cartService.deleteCart(user.getId());
        return ResponseEntity.ok("The cart is deleted");
    }


    /**
     * get user Cart
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Cart> getCart() {
        User user = userService.getUserConnected();
        Cart cart = cartService.findCartByUser(user.getId());
        return ResponseEntity.ok().body(cart);
    }




}
