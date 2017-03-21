package academy.binar.co.id.architecture.mvc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import academy.binar.co.id.architecture.R;
import academy.binar.co.id.architecture.mvc.Controller;

/**
 * Created by voen on 3/20/17.
 */

public class SecondScreen extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        controller = (Controller) getApplicationContext();
        showCartData();
    }

    private void showCartData() {
        int size = controller.getCart().getCartSize();
        LinearLayout container = (LinearLayout) findViewById(R.id.main_container);
        if(size > 0) {
            for(int i=0;i < size;i++) {
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                String name = controller.getCart().getProducts(i).getProductName();
                int price = controller.getCart().getProducts(i).getProductPrice();

                TextView textName = new TextView(this);
                textName.setText(name);

                TextView textPrice = new TextView(this);
                textPrice.setText("$ "+price);

                linearLayout.addView(textName);
                linearLayout.addView(textPrice);
                container.addView(linearLayout);
            }
        } else {
            TextView textView = new TextView(this);
            textView.setText("No Products");
            container.addView(textView);
        }
    }
}
