/**
 * Creates a CoffeeView
 * The CoffeeView class has a functionality needed for the rutgerscafe app
 * @author Kevin Liu, Gurveer Aulakh
 */
package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import sourcefiles.AddIns;
import sourcefiles.Coffee;
import sourcefiles.CoffeeSize;

public class CoffeeView extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner_size;
    Coffee coffee;
    CoffeeSize currentSize;
    CoffeeSize[] coffeeSize = CoffeeSize.values();
    CheckBox cream, caramel, milk, whipped_cream, syrup;
    private static final int INTIAL = 1;
    EditText coffee_subtotal;
    double price = 0;
    double roundedPrice = 0;

    /**
     * onCreate method creates the BasketView
     * @param savedInstanceState takes in the Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_view);
        spinner_size = findViewById(R.id.coffee_size);
        ArrayAdapter<CharSequence> adapter_size = ArrayAdapter.createFromResource(this,R.array.coffee_size_array,android.R.layout.simple_spinner_item);
        adapter_size.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_size.setAdapter(adapter_size);
        spinner_size.setOnItemSelectedListener(this);
        cream = findViewById(R.id.cream);
        caramel = findViewById(R.id.caramel);
        milk = findViewById(R.id.milk);
        whipped_cream = findViewById(R.id.whipped_cream);
        syrup = findViewById(R.id.syrup);
        coffee = new Coffee(coffeeSize[0], INTIAL);
        coffee_subtotal = findViewById(R.id.coffee_subtotal);
    }

    /**
     * onItemSelected method runs if item/button is selected
     * @param adapterView takes in the AdapterView
     * @param view takes in the View
     * @param i takes in the integer
     * @param l takes in the long data type
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        //Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_SHORT).show();
        switch (choice) {
            case "SHORT":
                currentSize = CoffeeSize.SHORT;
                break;
            case "TALL":
                currentSize = CoffeeSize.TALL;
                break;
            case "GRANDE":
                currentSize = CoffeeSize.GRANDE;
                break;
            default:
                currentSize = CoffeeSize.VENTI;
        }
        coffee.setSize(currentSize);
        price = coffee.itemPrice();
        roundedPrice = Math.round(price * 100.0) / 100.0;
        coffee_subtotal.setText("$" + roundedPrice);
    }

    /**
     * onNothingSelected method runs if item/button is not selected
     * @param adapterView takes in the AdapterView
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * creamClicked method runs if it is clicked
     * @param v takes in the View
     */
    public void creamClicked(View v) {
        clicked();
    }

    /**
     * caramelClicked method runs if it is clicked
     * @param v takes in the View
     */
    public void caramelClicked(View v) {
        clicked();
    }

    /**
     * milkClicked method runs if it is clicked
     * @param v takes in the View
     */
    public void milkClicked(View v) {
        clicked();
    }

    /**
     * whipped_creamClicked method runs if it is clicked
     * @param v takes in the View
     */
    public void whipped_creamClicked(View v) {
        clicked();
    }

    /**
     * syrupClicked method runs if it is clicked
     * @param v takes in the View
     */
    public void syrupClicked(View v) {
        clicked();
    }

    /**
     * clicked method runs if it is clicked
     */
    public void clicked() {
        AddIns creamAddIn = AddIns.CREAM;
        AddIns syrupAddIn = AddIns.SYRUP;
        AddIns milkAddIn = AddIns.MILK;
        AddIns caramelAddIn = AddIns.CARAMEL;
        AddIns whippedCreamAddIn = AddIns.WHIPPED_CREAM;

        if (cream.isChecked()) {
            coffee.add(creamAddIn);
        }
        else if (!cream.isChecked()) {
            coffee.remove(creamAddIn);
        }

        if (syrup.isChecked()) {
            coffee.add(syrupAddIn);
        }
        else if (!syrup.isChecked()) {
            coffee.remove(syrupAddIn);
        }

        if (milk.isChecked()) {
            coffee.add(milkAddIn);
        }
        else if (!milk.isChecked()) {
            coffee.remove(milkAddIn);
        }

        if (caramel.isChecked()) {
            coffee.add(caramelAddIn);
        }
        else if (!caramel.isChecked()) {
            coffee.remove(caramelAddIn);
        }

        if (whipped_cream.isChecked()) {
            coffee.add(whippedCreamAddIn);
        }
        else if (!whipped_cream.isChecked()) {
            coffee.remove(whippedCreamAddIn);
        }

        price = coffee.itemPrice();
        roundedPrice = Math.round(price * 100.0) / 100.0;
        coffee_subtotal.setText("$" + roundedPrice);
    }

    /**
     * addToOrder methods adds the coffee order
     * @param v takes in the View
     */
    public void addToOrder(View v) {
        MainActivity.order.add(coffee);
        Toast.makeText(getApplicationContext(), "Your Coffee Has Been Placed!", Toast.LENGTH_SHORT).show();
        finish();
    }
}