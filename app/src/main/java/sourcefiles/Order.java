/**
 * Creates a generic user order
 * The Order class has a unique order number and keeps the list of menu items added by the user
 * @author Kevin Liu, Gurveer Aulakh
 */

package sourcefiles;

import java.util.Arrays;
import java.util.LinkedList;

public class Order implements Customizable{
    private static final int INITIAL = 0;
    private static int numbers = INITIAL;
    private double subtotal;
    //private CoffeeNode cHead;
    //private DonutNode dHead;
    public LinkedList<Coffee> coffeeList = new LinkedList<Coffee>();
    public LinkedList<Donut> donutList = new LinkedList<Donut>();
    private final int orderNum;

    /**
     * Order constructor creates a unique order number
     */
    public Order () {
        orderNum = ++numbers;
    }

    /**
     * getOrderNum method returns the order number
     */
    public int getOrderNum() {
        return orderNum;
    }

    /**
     * Add methods adds the coffee order to the CoffeeList/DonutList
     * @param obj takes in the object obj
     * @return true if coffee/donut added, else false
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Coffee) {
//            CoffeeNode curr = new CoffeeNode((Coffee)obj);
//            return addHelperCoffee(curr);
            return (coffeeList.add((Coffee) obj));
        }
        else if (obj instanceof Donut) {
//            DonutNode curr = new DonutNode((Donut) obj);
//            return addHelperDonut(curr);
            return (donutList.add((Donut) obj));
        }
        else {
            return false;
        }
    }

    /**
     * remove methods removes the coffee/donut order from the CoffeeList/DonutList
     * @param obj takes in the object obj
     * @return true if coffee/donut added, else false
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Coffee) {
            //traverse through list of coffee order
            coffeeOuterLoop:
            for (int i = 0; i < coffeeList.size(); i++) {
                Coffee curr = coffeeList.get(i);
                if (curr.size != ((Coffee) obj).size) {
                    continue;
                }
                AddIns[] currList = curr.getAddins();
                AddIns[] objList = ((Coffee) obj).getAddins();
                if (currList.length != objList.length) {
                    continue;
                }
                addinsSort(currList);
                addinsSort(objList);
                for (int j = 0; j < currList.length; j++) {
                    if (!currList[j].equals(objList[j])) {
                        continue coffeeOuterLoop;
                    }
                }
                coffeeList.remove(i);
                return true;
            }
            return false;
        }
        else if (obj instanceof Donut) {
            for (int i = 0; i < donutList.size(); i++) {
                Donut curr = donutList.get(i);
                Donut other = (Donut) obj;
                if (curr.toString().equals(other.toString())) {
                    donutList.remove(i);
                    return true;
                }
            }
            return false;
        }
        else {
            return false;
        }
    }

    /**
     * addHelperCoffee methods is a helper method for the add method
     * @param curr takes in the CoffeeNode curr
     * @return true if node added, else false
     */
//    private boolean addHelperCoffee(CoffeeNode curr) {
//        if (cHead == null) {
//            cHead = curr;
//            return true;
//        }
//        CoffeeNode ptr = cHead;
//        while (ptr.next != null) {
//            ptr = ptr.next;
//        }
//        ptr.next = curr;
//        return true;
//    }

    /**
     * addHelperDonut methods is a helper method for the add method
     * @param curr takes in the DonutNode curr
     * @return true if node added, else false
     */
//    private boolean addHelperDonut(DonutNode curr) {
//        if (dHead == null) {
//            dHead = curr;
//            return true;
//        }
//        DonutNode ptr = dHead;
//        while (ptr.next != null) {
//            ptr = ptr.next;
//        }
//        ptr.next = curr;
//        return true;
//    }

    /**
     * sorts the list by the natural order in AddIns class
     * @param list list of addins of the order
     */
    private void addinsSort (AddIns[] list) {
        Arrays.sort(list);
    }

    public double getSubtotal() {
        subtotal = INITIAL;
        for (Coffee c : coffeeList) {
            subtotal += c.itemPrice();
        }
        for (Donut d : donutList) {
            subtotal += d.itemPrice();
        }
        return subtotal;
    }

    public String toString() {
        return "Order# " + orderNum;
    }
}