package sacha.shoppyng.cart.controller;

import sacha.shoppyng.cart.model.Cart;
import sacha.shoppyng.cart.model.Product;
import sacha.shoppyng.cart.model.User;
import sacha.shoppyng.cart.service.CartService;
import sacha.shoppyng.cart.service.ProductService;
import sacha.shoppyng.cart.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Product Controller.
 */
@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private final ProductService productService;

    private final CartService cartService;

    private final UserService userService;

    public ProductRestController(CartService cartService, ProductService productService, UserService userService) {
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }

    /**
     * Add a product to user card
     * @param product
     * @return
     */
    @PostMapping("")
    public void addProduct(@RequestBody Product product) {
        User user = userService.getUserConnected();
        Cart cart = cartService.findCartByUser(user.getId());
        productService.addProduct(cart, product);
    }

    /**
     * Remove product from cart
     * @param product
     * @return
     */
    @DeleteMapping("")
    public ResponseEntity removeProduct(@RequestBody Product product) {
        User user = userService.getUserConnected();
        Cart cart = cartService.findCartByUser(user.getId());
        productService.removeProduct(cart, product);
        return ResponseEntity.ok().body(null);
    }

    /**
     * Remove All Product
     * @return
     */
    @DeleteMapping("/removeAll")
    public ResponseEntity clearCart() {
        User user = userService.getUserConnected();
        Cart cart = cartService.findCartByUser(user.getId());
        productService.clearCart(cart);
        return ResponseEntity.ok().body(null);
    }

}
