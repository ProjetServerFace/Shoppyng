package sacha.shoppyng.cart.service;

import sacha.shoppyng.cart.model.Cart;
import sacha.shoppyng.cart.model.Product;
import org.springframework.stereotype.Service;

/**
 * Product Service.
 */
@Service
public class ProductService {

    /**
     * Add Product
     * @param cart
     * @param product
     * @return
     */
    public void addProduct(Cart cart, Product product) {
        if (cart != null)
        {
            if( findProduct(cart,product)==null ){
                cart.getProducts().add(product);
            }else {
                throw new RuntimeException("The product already exists");
            }
        } else {
            throw new RuntimeException(" The user does not have a shopping cart");
        }
    }

    /**
     * Remove Product
     * @param cart
     * @param product
     * @return
     */
    public void removeProduct(Cart cart, Product product) {
        if (cart != null )
        {
            if( findProduct(cart,product)!=null ){
                cart.getProducts().remove(product);
            }else {
                throw new RuntimeException("The product does not exist");
            }

        } else {
            throw new RuntimeException("The user does not have a shopping cart");
        }
    }

    /**
     * Clear cart
     * @param cart
     * @return
     */
    public void clearCart(Cart cart) {
        if (cart != null)
        {
            cart.getProducts().clear();
        } else {
            throw new RuntimeException("The user does not have a shopping cart");
        }
    }

    /**
     * Find Product
     * @param cart
     * @param product
     * @return
     */
    public Product findProduct(Cart cart, Product product) {

        if (cart.getProducts()!=null && !cart.getProducts().isEmpty()) {
            return cart.getProducts().stream().filter(p ->p.getId().equals(product.getId())).findFirst().orElseGet(null);
        } else {
            return null;
        }
    }





}
