package academy.binar.co.id.architecture.mvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import academy.binar.co.id.architecture.R;
import academy.binar.co.id.architecture.mvc.Controller;
import academy.binar.co.id.architecture.mvc.model.ModelProducts;

/**
 * Created by voen on 3/20/17.
 */

public class FirstScreen extends AppCompatActivity {
    Controller controller;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        controller = (Controller) getApplicationContext();

        if(controller.getProductArrayListSize() == 0) {
            initDummyData();
        }

        showData();
    }

    private void initDummyData() {
        ModelProducts productObject;
        for(int i=1;i<=4;i++)
        {
            int price = 10+i;
            productObject = new ModelProducts("Product "+i,"Description "+i,price);
            controller.setProducts(productObject);
        }
    }

    private void showData(){
        int size = controller.getProductArrayListSize();
        final LinearLayout container = (LinearLayout) findViewById(R.id.main_container);

        for(int i =0; i < size;i++) {
            String name = controller.getProducts(i).getProductName();
            int price = controller.getProducts(i).getProductPrice();

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
                    ModelProducts modelProducts = controller.getProducts(index);
                    if(!controller.getCart().checkProductInCart(modelProducts)) {
                        controller.getCart().setProduct(modelProducts);
                        Toast.makeText(FirstScreen.this,modelProducts.getProductName()+" Added to cart", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(FirstScreen.this,modelProducts.getProductName()+" already on cart", Toast.LENGTH_LONG).show();
                    }
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
                Intent intent = new Intent(FirstScreen.this, SecondScreen.class);
                startActivity(intent);
            }
        });
        container.addView(button);
    }
}
