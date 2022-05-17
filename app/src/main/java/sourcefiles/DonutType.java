/**
 The DonutType class implements the prices for each donut type.
 It has a method that returns the price of each donut type.
 @author Kevin Liu, Gurveer Aulakh
 */

package sourcefiles;

public enum DonutType {
    YEAST_DONUT (1.59),
    CAKE_DONUT (1.79),
    DONUT_HOLES (0.39);

    private final double donutPrice;

    /**
     * DonutType constructor stores the price into the instance variable.
     * @param price the price for each donut type
     */
    DonutType(double price) {
        donutPrice = price;
    }

    /**
     * getDonutPrice method returns the price of the donut
     * @return the donut price.
     */
    public double getDonutPrice() {
        return donutPrice;
    }


}