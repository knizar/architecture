package academy.binar.co.id.architecture.mvp.model;

import java.util.ArrayList;

/**
 * Created by voen on 3/20/17.
 */

public class ModelCart {
    private ArrayList<ModelProducts> cartProduct = new ArrayList<>();

    public ModelProducts getProducts(int pos) {
        return cartProduct.get(pos);
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
