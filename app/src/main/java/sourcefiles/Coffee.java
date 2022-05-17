/**
 * creates the Coffee class that inherits from generic MenuItem class
 * @author Kevin Liu, Gurveer Aulakh
 */

package sourcefiles;

public class Coffee extends MenuItem implements Customizable {
    private AddIns[] list = new AddIns[5];
    public CoffeeSize size;
    public int quantity;
    private int addOnCounter;
    private static final int EMPTY = 0;
    private static final double ADD_ON_PRICE = 0.3;

    /**
     * Coffee constructor calls to super constructor and also initialize the price
     * @param size the size of the coffee cup
     */
    public Coffee(CoffeeSize size, int quantity) {
        super((size.getPrice() * quantity));
        this.size = size;
        this.quantity = quantity;
        addOnCounter = EMPTY;
    }

    /**
     * add method add the addin to the Coffee object
     * @param obj obj takes in the obj object
     * @return if added true ,otherwise false
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof AddIns) {
            //check if the addin already in the list, return false if exist
            for (AddIns addIns : list) {
                if (addIns != null) {
                    if (addIns.name().equals(((AddIns) obj).name())) {
                        return false;
                    }
                }
            }

            //otherwise find the first empty spot and insert the addin
            int tempIndex = -1;
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    tempIndex = i;
                    break;
                }
            }
            list[tempIndex] = (AddIns) obj;
            addOnCounter++;
            price += (ADD_ON_PRICE * quantity);
            return true;
        }
        return false;
    }

    /**
     * remove method removes the addin from the coffee object
     * @param obj obj takes in the obj object
     * @return if removed true ,otherwise false
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof AddIns) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null) {
                    //find if the addin already exist in the list
                    if (list[i].name().equals( ((AddIns) obj).name() )) {
                        list[i] = null;
                        addOnCounter--;
                        price -= (ADD_ON_PRICE * quantity);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * changes the size of the current coffee
     * @param newSize the new size of the coffee cup
     */
    public void setSize (CoffeeSize newSize) {
        price -= (size.getPrice() * quantity);
        size = newSize;
        price += (size.getPrice() * quantity);
    }

    /**
     * changes the quantity of the coffee
     * @param newQuantity the new amount of coffee
     */
    public void setQuantity(int newQuantity) {
        price -= (size.getPrice() * quantity);
        quantity = newQuantity;
        price += (size.getPrice() * quantity);
    }

    /**
     * Concat the size of coffee and addins to a string
     * @return a String with details about the coffee order
     */
    @Override
    public String toString() {
        String coffeeDetails = "";
        coffeeDetails = coffeeDetails.concat(quantity + " " + size.name() + " Coffee w. ");
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (i == list.length-1) {
                    coffeeDetails = coffeeDetails.concat(list[i].name());
                }
                else {
                    coffeeDetails = coffeeDetails.concat(list[i].name() + ", ");
                }
            }
        }
        return coffeeDetails;
    }

    public AddIns[] getAddins() {
        AddIns[] finalList = new AddIns[addOnCounter];
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                finalList[counter++] = list[i];
            }
        }
        return finalList;
    }
}