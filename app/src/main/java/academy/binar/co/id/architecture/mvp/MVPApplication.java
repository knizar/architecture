package academy.binar.co.id.architecture.mvp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import academy.binar.co.id.architecture.mvc.model.ModelCart;
import academy.binar.co.id.architecture.mvc.model.ModelProducts;

/**
 * Created by voen on 3/20/17.
 */

public class MVPApplication extends Application {
    private ArrayList<ModelProducts> myProducts = new ArrayList<>();
    private ModelCart myCart = new ModelCart();

    public ModelProducts getProducts(int pos) {
        return myProducts.get(pos);
    }

    public List<ModelProducts> getListProduct() {
        return myProducts;
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
