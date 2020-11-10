package sacha.shoppyng.sourceTest.service;

import sacha.shoppyng.cart.Repository.CartRepository;
import sacha.shoppyng.cart.model.Cart;
import sacha.shoppyng.cart.model.User;

import java.util.ArrayList;

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
