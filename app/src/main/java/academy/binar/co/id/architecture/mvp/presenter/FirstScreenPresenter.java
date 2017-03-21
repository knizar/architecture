package academy.binar.co.id.architecture.mvp.presenter;

import academy.binar.co.id.architecture.mvc.model.ModelProducts;
import academy.binar.co.id.architecture.mvp.MVPApplication;
import academy.binar.co.id.architecture.mvp.view.FirstScreenView;

/**
 * Created by voen on 3/20/17.
 */

public class FirstScreenPresenter {
    private FirstScreenView view;
    private MVPApplication mvpApplication;

    public FirstScreenPresenter(FirstScreenView view, MVPApplication mvpApplication) {
        this.view = view;
        this.mvpApplication = mvpApplication;
    }

    public void initData() {
        if(mvpApplication.getProductArrayListSize()==0) {
            ModelProducts productObject;
            for(int i=1;i<=4;i++)
            {
                int price = 10+i;
                productObject = new ModelProducts("Product "+i,"Description "+i,price);
                mvpApplication.setProducts(productObject);
            }
        }

        view.showData(mvpApplication.getListProduct());
    }

    public void addToCart(ModelProducts modelProducts) {
        if(!mvpApplication.getCart().checkProductInCart(modelProducts)) {
            mvpApplication.getCart().setProduct(modelProducts);
            view.showMessage(modelProducts.getProductName()+" added to cart");
        } else {
            view.showMessage(modelProducts.getProductName()+" already on cart");
        }
    }
}
