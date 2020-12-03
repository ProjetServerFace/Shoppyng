package sacha.shoppyng.cart.Repository;

import sacha.shoppyng.cart.model.Cart;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Cart Repository.
 */
@Getter
@Repository
public class CartRepository {

    private final List<Cart> carts;

    public CartRepository() {
        carts = new ArrayList<>();
    }

    /**
     * Create Cart
     * @param cart
     * @return
     */
    public Cart createCart(Cart cart) {
        carts.add(cart);
        return cart;
    }
    /**
     * delete cart
     * @param cart
     * @return
     */
    public void deleteCart(Cart cart) {
        carts.remove(cart);
    }

    /**
     * Find card by User ID
     * @param idUser
     * @return Optional<Cart>
     */
    public Optional<Cart> findCartByUserId(Long idUser) {
        return carts.stream().filter(cart -> cart.getUser().getId().equals(idUser)).findFirst();
    }


}
