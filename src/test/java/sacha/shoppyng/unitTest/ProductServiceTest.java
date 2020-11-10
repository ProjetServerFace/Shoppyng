package sacha.shoppyng.unitTest;

import sacha.shoppyng.cart.model.Cart;
import sacha.shoppyng.cart.model.Product;
import sacha.shoppyng.cart.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test(expected = RuntimeException.class)
    public void shouldThrowUserHaveCart() {
        productService.addProduct(null, null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowCartHaveProduct() {
        Product product = new Product();
        product.setId(1L);
        Cart cart = new Cart();
        cart.setProducts(new ArrayList<>());
        cart.getProducts().add(product);
        productService.addProduct(cart, product);
    }

    // TODO faire pareil pour les autres méthodes


}
