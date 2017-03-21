package academy.binar.co.id.architecture.mvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by voen on 3/20/17.
 */

public class ModelCart {
    private ArrayList<ModelProducts> cartProduct = new ArrayList<>();

    public ModelProducts getProducts(int pos) {
        return cartProduct.get(pos);
    }

    public List<ModelProducts> getListProducts() {
        return cartProduct;
    }

    public void setProduct(ModelProducts product) {
        cartProduct.add(product);
    }

    public int getCartSize() {
        return cartProduct.size();
    }

    public boolean checkProductInCart(ModelProducts products) {
        return cartProduct.contains(products);
    }
}
