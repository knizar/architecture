package academy.binar.co.id.architecture.mvc;

import android.app.Application;

import java.util.ArrayList;

import academy.binar.co.id.architecture.mvc.model.ModelCart;
import academy.binar.co.id.architecture.mvc.model.ModelProducts;

/**
 * Created by voen on 3/20/17.
 */

public class Controller extends Application {
    private ArrayList<ModelProducts> myProducts = new ArrayList<>();
    private ModelCart myCart = new ModelCart();

    public ModelProducts getProducts(int pos) {
        return myProducts.get(pos);
    }

    public void setProducts(ModelProducts products) {
        myProducts.add(products);
    }

    public ModelCart getCart() {
        return myCart;
    }

    public int getProductArrayListSize() {
        return myProducts.size();
    }
}
