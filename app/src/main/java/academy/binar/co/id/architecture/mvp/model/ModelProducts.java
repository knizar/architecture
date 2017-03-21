package academy.binar.co.id.architecture.mvp.model;

/**
 * Created by voen on 3/20/17.
 */

public class ModelProducts {
    private String productName;
    private String productDesc;
    private int productPrice;

    public ModelProducts(String productName, String productDesc, int productPrice) {

        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public int getProductPrice() {
        return productPrice;
    }
}
