package academy.binar.co.id.architecture.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import academy.binar.co.id.architecture.R;
import academy.binar.co.id.architecture.mvc.model.ModelProducts;
import academy.binar.co.id.architecture.mvc.view.FirstScreen;
import academy.binar.co.id.architecture.mvc.view.SecondScreen;
import academy.binar.co.id.architecture.mvp.MVPApplication;
import academy.binar.co.id.architecture.mvp.presenter.FirstScreenPresenter;

/**
 * Created by voen on 3/20/17.
 */

public class FirstScreenActivity extends AppCompatActivity implements FirstScreenView {
    private FirstScreenPresenter presenter;
    private MVPApplication mvpApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mvpApplication = (MVPApplication) getApplicationContext();
        presenter = new FirstScreenPresenter(this, mvpApplication);

        presenter.initData();
    }

    @Override
    public void showData(final List<ModelProducts> productsList) {
        int size = productsList.size();
        final LinearLayout container = (LinearLayout) findViewById(R.id.main_container);

        for(int i =0; i < size;i++) {
            String name = productsList.get(i).getProductName();
            int price = productsList.get(i).getProductPrice();

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            TextView product = new TextView(this);
            product.setText(" "+name+"    ");

            //Add textView to LinearLayout
            ll.addView(product);

            TextView textPrice = new TextView(this);
            textPrice.setText("  $"+price+"     ");

            //Add textView to LinearLayout
            ll.addView(textPrice);

            final Button btn = new Button(this);
            final int index = i;
            btn.setId(i+1);
            btn.setText("Add To Cart");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModelProducts modelProducts = productsList.get(index);
                    presenter.addToCart(modelProducts);
                }
            });
            ll.addView(btn);
            container.addView(ll);
        }

        Button button = new Button(this);
        button.setText("Go To Cart");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreenActivity.this, SecondScreenActivity.class);
                startActivity(intent);
            }
        });
        container.addView(button);
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
