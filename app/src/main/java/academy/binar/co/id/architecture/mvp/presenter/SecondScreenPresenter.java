package academy.binar.co.id.architecture.mvp.presenter;

import academy.binar.co.id.architecture.mvc.model.ModelProducts;
import academy.binar.co.id.architecture.mvp.MVPApplication;
import academy.binar.co.id.architecture.mvp.view.FirstScreenView;
import academy.binar.co.id.architecture.mvp.view.SecondScreenView;

/**
 * Created by voen on 3/20/17.
 */

public class SecondScreenPresenter {
    private SecondScreenView view;
    private MVPApplication mvpApplication;

    public SecondScreenPresenter(SecondScreenView view, MVPApplication mvpApplication) {
        this.view = view;
        this.mvpApplication = mvpApplication;
    }

    public void showCartData() {
        int size = mvpApplication.getCart().getCartSize();
        if(size > 0) {
            view.showData(mvpApplication.getCart().getListProducts());
        } else {
            view.showEmptyCart();
        }
    }
}
