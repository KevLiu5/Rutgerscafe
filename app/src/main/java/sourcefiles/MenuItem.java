/**
 * Creates a generic menuItem for the order
 * The MenuItem class is the superclass of all menu items, such as donuts and coffee.
 * @author Kevin Liu, Gurveer Aulakh
 */

package sourcefiles;

public abstract class MenuItem {
    protected double price;

    /**
     * MenuItem constructor sets the price
     * @param price takes in the double data type
     */
    public MenuItem(double price) {
        this.price = price;
    }

    /**
     * itemPrice methods returns price of the item
     * @return the double data type
     */
    public double itemPrice() {
        return price;
    }
}