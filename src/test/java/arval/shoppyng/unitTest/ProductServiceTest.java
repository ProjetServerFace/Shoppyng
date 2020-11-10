package arval.shoppyng.unitTest;

import arval.shoppyng.cart.model.Cart;
import arval.shoppyng.cart.model.Product;
import arval.shoppyng.cart.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
