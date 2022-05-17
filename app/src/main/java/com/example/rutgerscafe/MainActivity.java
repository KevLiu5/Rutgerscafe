/**
 * Creates a MainActivity
 * This is an MainActivity class to be used to instantiate an adapter for the RecyclerView.
 * @author Kevin Liu, Gurveer Aulakh
 */
package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import sourcefiles.Order;
import sourcefiles.StoreOrder;

public class MainActivity extends AppCompatActivity {

    ImageView imageView_donut;
    ImageView imageView_coffee;
    ImageView imageView_basket;
    ImageView imageView_store_order;
    public static Order order = new Order();
    public static StoreOrder storeOrder = new StoreOrder();



    /**
     * onCreate method creates the BasketView
     * @param savedInstanceState takes in the Bundle Object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_donut = findViewById(R.id.imageView_donut);
        imageView_donut.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick method runs if the item/button is clicked
             * @param v takes in the view object
             */
            @Override
            public void onClick(View v) {
                openDonutView();
            }
        });

        imageView_coffee = findViewById(R.id.imageView_coffee);
        imageView_coffee.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick method runs if the item/button is clicked
             * @param v takes in the view object
             */
            @Override
            public void onClick(View v) {
                openCoffeeView();
            }
        });

        imageView_basket = findViewById(R.id.imageView_basket);
        imageView_basket.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick method runs if the item/button is clicked
             * @param v takes in the view object
             */
            @Override
            public void onClick(View v) {
                openBasketView();
            }
        });

        imageView_store_order = findViewById(R.id.imageView_store_order);
        imageView_store_order.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick method runs if the item/button is clicked
             * @param v takes in the view object
             */
            @Override
            public void onClick(View v) {
                openStoreOrder();
                Intent intent = new Intent(MainActivity.this, StoreOrderView.class);
                startActivity(intent);
            }
        });

    }

    /**
     * openDonutView method opens the donutView
     */
    private void openDonutView() {
        Intent intent = new Intent(this, DountView.class);
        startActivity(intent);
    }

    /**
     * openCoffeeView method opens the coffeeView
     */
    private void openCoffeeView() {
        Intent intent = new Intent(this, CoffeeView.class);
        startActivity(intent);

    }

    /**
     * openBasketView method opens the basketView
     */
    private void openBasketView() {
        Intent intent = new Intent(this, BasketView.class);
        startActivity(intent);
    }

    /**
     * openStoreOrder method opens the StoreOrderView
     */
    private void openStoreOrder() {
        Intent intent = new Intent(this, StoreOrderView.class);
        startActivity(intent);
    }

}
