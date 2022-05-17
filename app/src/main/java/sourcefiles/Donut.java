/**
 * creates the Donut class that inherits from generic MenuItem class
 * @author Kevin Liu, Gurveer Aulakh
 */

package sourcefiles;

public class Donut extends MenuItem{

    String name;
    int quantity;

    /**
     * Donut constructor calls to super constructor and also initialize the price
     * @param name the name of the donut
     * @param price the price of the donut
     * @param quantity the quantity of the donut
     */
    public Donut(String name, double price, int quantity) {
        super((price * quantity));
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * toString methods concat the type of donut and flavor
     * @return a String with details about the donut order
     */
    @Override
    public String toString() {
        return quantity + " " + name;
    }
}