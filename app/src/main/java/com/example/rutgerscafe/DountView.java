/**
 * Creates a DonutItem
 * The DonutItem class has a functionality needed for the rutgerscafe app
 * @author Kevin Liu, Gurveer Aulakh
 */
package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DountView extends AppCompatActivity {

    private ArrayList<DonutItem> items = new ArrayList<>();
    private int [] itemImages = {R.drawable.glazed, R.drawable.sprinkled, R.drawable.jelly,
            R.drawable.sour_cream, R.drawable.boston_cream, R.drawable.cinnamon_twist, R.drawable.crullers,
            R.drawable.chocolate, R.drawable.vanilla, R.drawable.pershing, R.drawable.berliner,
            R.drawable.coconut};

    /**
     * Get the references of all instances of Views defined in the layout file, set up the list of
     * items to be display in the RecyclerView.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dount_view);
        RecyclerView rcview = findViewById(R.id.rcView_donut);
        setupMenuItems(); //add the list of items to the ArrayList
        ItemsAdapter adapter = new ItemsAdapter(this, items); //create the adapter
        rcview.setAdapter(adapter); //bind the list of items to the RecyclerView
        //use the LinearLayout for the RecyclerView
        rcview.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Helper method to set up the data (the Model of the MVC).
     */
    private void setupMenuItems() {
        /*
         * Item names are defined in a String array under res/string.xml.
         * Your item names might come from other places, such as an external file, or the database
         * from the backend.
         */
        String [] itemNames = getResources().getStringArray(R.array.itemNames);
        /* Add the items to the ArrayList.
         * Note that I use hardcoded prices for demo purpose. This should be replace by other
         * data sources.
         */
        double price = 1.39;
        DecimalFormat df = new DecimalFormat("$##0.00");
//        df.format(price);
        for (int i = 0; i < itemNames.length; i++) {
            price += .30;
            items.add(new DonutItem(itemNames[i], itemImages[i], String.valueOf(df.format(price))));
        }
    }

}