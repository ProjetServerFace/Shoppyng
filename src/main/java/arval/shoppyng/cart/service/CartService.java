package arval.shoppyng.cart.service;

import arval.shoppyng.cart.Repository.CartRepository;
import arval.shoppyng.cart.model.Cart;
import arval.shoppyng.cart.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Cart Service.
 */
@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(User user) {
        Optional<Cart> cartFound = cartRepository.findCartByUserId(user.getId());
        if (!cartFound.isPresent()) {
            Cart cart = new Cart();
            cart.setId(System.currentTimeMillis());
            cart.setProducts(new ArrayList<>());
            cart.setUser(user);
            return cartRepository.createCart(cart);
        } else {
            throw new RuntimeException("L'utilisateur a déjà un panier");
        }
    }

    public void deleteCart(Long idUser) {
        Optional<Cart> cart = cartRepository.findCartByUserId(idUser);
        if (cart.isPresent()) {
            cartRepository.deleteCart(cart.get());
        } else {
            throw new RuntimeException("L'utilisateur n'a pas de panier");
        }
    }


    public Cart findCartByUser(Long idUser) {
        return cartRepository.findCartByUserId(idUser).orElseGet(null);
    }


}
