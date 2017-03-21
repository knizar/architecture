package academy.binar.co.id.architecture.mvp.view;

import java.util.List;

import academy.binar.co.id.architecture.mvc.model.ModelProducts;

/**
 * Created by voen on 3/20/17.
 */

public interface FirstScreenView {
    void showData(List<ModelProducts> productsList);

    void showMessage(String s);
}
