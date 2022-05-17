/**
 * Creates a BasketView
 * The BasketView class has a functionality needed for the rutgerscafe app
 * @author Kevin Liu, Gurveer Aulakh
 */

package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sourcefiles.Coffee;
import sourcefiles.Donut;
import sourcefiles.Order;

public class BasketView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView_basket;
    EditText basket_subtotal, sales_tax, totals;
    private static final double EMPTY = 0;
    Order order = MainActivity.order;
    double subtotal = EMPTY;
    double saleTax = EMPTY;
    double total = EMPTY;

    /**
     * onCreate method creates the BasketView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_view);
        listView_basket = findViewById(R.id.listView_basket);
        basket_subtotal = findViewById(R.id.basket_subtotal);
        sales_tax = findViewById(R.id.sales_tax);
        totals = findViewById(R.id.totals);

        int dCounter = 1;
        int cCounter = 1;
        ArrayList<String> order_list = new ArrayList<String>();
        for (Donut i: MainActivity.order.donutList) {
            order_list.add("D#" + dCounter + ": " + i.toString());
            dCounter++;
        }
        for (Coffee i: MainActivity.order.coffeeList) {
            order_list.add("C#" + cCounter + ": " + i.toString());
            cCounter++;
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, order_list);

        listView_basket.setAdapter(arrayAdapter);
        listView_basket.setOnItemClickListener(this);

        subtotal = order.getSubtotal();
        subtotal = Math.round(subtotal * 100.0) / 100.0;
        basket_subtotal.setText("$" + subtotal);
        saleTax = subtotal * 0.06625;
        saleTax = Math.round(saleTax * 100.0) / 100.0;
        sales_tax.setText("$" + saleTax);
        total = subtotal * 1.06625;
        total = Math.round(total * 100.0) / 100.0;
        totals.setText("$" + total);
    }

    private void showList () {
        int dCounter = 1;
        int cCounter = 1;
        ArrayList<String> order_list = new ArrayList<String>();
        for (Donut i: MainActivity.order.donutList) {
            order_list.add("D#" + dCounter + ": " + i.toString());
            dCounter++;
        }
        for (Coffee i: MainActivity.order.coffeeList) {
            order_list.add("C#" + cCounter + ": " + i.toString());
            cCounter++;
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, order_list);

        listView_basket.setAdapter(arrayAdapter);
        listView_basket.setOnItemClickListener(this);

        subtotal = order.getSubtotal();
        subtotal = Math.round(subtotal * 100.0) / 100.0;
        basket_subtotal.setText("$" + subtotal);
        saleTax = subtotal * 0.06625;
        saleTax = Math.round(saleTax * 100.0) / 100.0;
        sales_tax.setText("$" + saleTax);
        total = subtotal * 1.06625;
        total = Math.round(total * 100.0) / 100.0;
        totals.setText("$" + total);
    }

    /**
     * This is the method you must implement when you write implements AdapterView.OnItemClickListener
     * in the class heading.
     * This is the event handler for the onItemClick event.
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Do you want to delete?");
        alert.setMessage(adapterView.getAdapter().getItem(i).toString());
        //anonymous inner class to handle the onClick event of YES or NO.
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "YES", Toast.LENGTH_LONG).show();
                String currItem = adapterView.getAdapter().getItem(i).toString();
                String itemType = currItem.substring(0,1);
                int index = Integer.parseInt(currItem.substring(2, 3));
                switch (itemType) {
                    case "D":
                        index--;
                        order.donutList.remove(index);
                        break;
                    case "C":
                        index--;
                        order.coffeeList.remove(index);
                        break;
                }
                showList();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void placeOrderBtn(View view) {
        if (Double.compare(total, EMPTY) != 0) {
            MainActivity.storeOrder.add(order);
            MainActivity.order = new Order();
            showList();
            Toast.makeText(getApplicationContext(), "Your Order Has Been Placed!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(), "Order cannot be Empty!", Toast.LENGTH_SHORT).show();
        }
    }
}