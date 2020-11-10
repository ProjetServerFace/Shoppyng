package arval.shoppyng.cart.model;

import lombok.Data;

import java.util.ArrayList;

/**
 * Cart Model.
 */
@Data
public class Cart {

    private Long id;

    private User user;

    private ArrayList<Product> products;
}
