package arval.shoppyng.sourceTest.service;

import arval.shoppyng.cart.Repository.CartRepository;
import arval.shoppyng.cart.model.Cart;
import arval.shoppyng.cart.model.User;

import java.util.ArrayList;
import java.util.Optional;

public class CartRepositoryMock extends CartRepository {

    public CartRepositoryMock() {
        super();
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setUser(new User(1L, "userTest", ""));
        cart.setProducts(new ArrayList<>());
        this.getCarts().add(cart);
    }

}
