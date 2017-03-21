package academy.binar.co.id.architecture.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import academy.binar.co.id.architecture.R;
import academy.binar.co.id.architecture.mvc.model.ModelProducts;
import academy.binar.co.id.architecture.mvp.MVPApplication;
import academy.binar.co.id.architecture.mvp.presenter.SecondScreenPresenter;

/**
 * Created by voen on 3/20/17.
 */

public class SecondScreenActivity extends AppCompatActivity implements SecondScreenView {
    private SecondScreenPresenter presenter;
    private MVPApplication mvpApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mvpApplication = (MVPApplication) getApplicationContext();
        presenter = new SecondScreenPresenter(this, mvpApplication);

        presenter.showCartData();
    }

    @Override
    public void showData(List<ModelProducts> productsList) {
        LinearLayout container = (LinearLayout) findViewById(R.id.main_container);
        int size = productsList.size();

        for(int i=0;i < size;i++) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            String name = productsList.get(i).getProductName();
            int price = productsList.get(i).getProductPrice();

            TextView textName = new TextView(this);
            textName.setText(name);

            TextView textPrice = new TextView(this);
            textPrice.setText("$ "+price);

            linearLayout.addView(textName);
            linearLayout.addView(textPrice);
            container.addView(linearLayout);
        }
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEmptyCart() {
        LinearLayout container = (LinearLayout) findViewById(R.id.main_container);
        TextView textView = new TextView(this);
        textView.setText("No Products");
        container.addView(textView);
    }
}
