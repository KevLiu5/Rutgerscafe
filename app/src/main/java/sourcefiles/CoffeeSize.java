/**
 The CoffeeSize class implements the prices for each coffee size.
 It has a method that returns the price of each coffee size.
 @author Kevin Liu, Gurveer Aulakh
 */

package sourcefiles;

public enum CoffeeSize {
    SHORT (1.69),
    TALL (2.09),
    GRANDE (2.49),
    VENTI (2.89);

    private final double CoffeeSizePrice;

    /**
     * CoffeeSize constructor stores the price into the instance variable.
     * @param sizePrice the price for each donut type
     */
    CoffeeSize(double sizePrice) {
        CoffeeSizePrice = sizePrice;
    }

    /**
     * getDonutPrice method returns the price of the donut
     * @return the donut price.
     */
    public double getPrice() {
        return CoffeeSizePrice;
    }
}