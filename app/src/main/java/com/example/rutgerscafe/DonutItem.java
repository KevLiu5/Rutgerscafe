/**
 * Creates a DonutItem
 * The DonutItem class has a functionality needed for the rutgerscafe app
 * @author Kevin Liu, Gurveer Aulakh
 */
package com.example.rutgerscafe;

import java.io.Serializable;

public class DonutItem implements Serializable {
    private String itemName;
    private int image;
    private String unitPrice; //for demo purpose, the unitPrice is of String type

    /**
     * Parameterized constructor.
     * @param itemName
     * @param image
     * @param unitPrice
     */
    public DonutItem(String itemName, int image, String unitPrice) {
        this.itemName = itemName;
        this.image = image;
        this.unitPrice = unitPrice;
    }

    /**
     * Getter method that returns the item name of an item.
     * @return the item name of an item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Getter method that returns the image of an item.
     * @return the image of an item.
     */
    public int getImage() {
        return image;
    }

    /**
     * Getter method that returns the unit price.
     * @return the unit price of the item.
     */
    public String getUnitPrice() {
        return unitPrice;
    }
}
