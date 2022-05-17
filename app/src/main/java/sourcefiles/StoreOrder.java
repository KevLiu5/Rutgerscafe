/**
 * this class keeps a list of orders placed by the user.
 * The storeOrder implement behavior of adding and removing orders from the database
 * @author Kevin Liu, Gurveer Aulakh
 */

package sourcefiles;

import java.util.LinkedList;

public class StoreOrder implements Customizable{
    public LinkedList<Order> list;

    /**
     * StoreOrder constructor creates a new list of Orders
     */
    public StoreOrder () {
        list = new LinkedList<Order>();
    }

    /**
     * add methods adds the order to the list
     * @param obj takes in the object obj
     * @return true if order added, else false
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            return list.add((Order) obj);
        }
        return false;
    }

    /**
     * remove methods removes the order from the list
     * @param obj takes in the object obj
     * @return true if order removed, else false
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof String) {
            int orderNum = Integer.parseInt((String) obj);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getOrderNum() == orderNum) {
                    list.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}