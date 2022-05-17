package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import sourcefiles.Coffee;
import sourcefiles.Donut;
import sourcefiles.Order;

public class StoreOrderView extends AppCompatActivity {

    ListView listView_donut;
    /**
     * onCreate method creates the BasketView
     * @param savedInstanceState takes in the Bundle Object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);
        listView_donut = findViewById(R.id.listView_donut);
        ArrayList<String> storeOrder_list = new ArrayList<String>();
        for (int i = 0; i < MainActivity.storeOrder.list.size(); i++) {
            storeOrder_list.add(MainActivity.storeOrder.list.get(i).toString());
            int dCounter = 1;
            int cCounter = 1;
            ArrayList<String> order_list = new ArrayList<String>();
            for (Donut j: MainActivity.storeOrder.list.get(i).donutList) {
                storeOrder_list.add("D#" + dCounter + ": " + j.toString());
                dCounter++;
            }
            for (Coffee k: MainActivity.storeOrder.list.get(i).coffeeList) {
                storeOrder_list.add("C#" + cCounter + ": " + k.toString());
                cCounter++;
            }
            //storeOrder_list.add(order_list.toString());
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, storeOrder_list);
        listView_donut.setAdapter(arrayAdapter);
//        listView_donut.setOnItemClickListener(this);
    }
}