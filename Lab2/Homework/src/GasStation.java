/**
 * The GasStation class represents a gas station with a name, coordinates, and gas price.
 */
public class GasStation extends Location {
    /**
     * The price of gas at the gas station.
     */
    private int gasPrice;

    /**
     * Creates a new GasStation object with the specified name, coordinates, and gas price.
     *
     * @param name the name of the gas station
     * @param x the x coordinate of the gas station
     * @param y the y coordinate of the gas station
     * @param gasPrice the price of gas at the gas station
     */
    public GasStation(String name, double x, double y, int gasPrice) {
        super(name, x, y);
        this.gasPrice = gasPrice;
    }

    /**
     * Returns the price of gas at the gas station.
     *
     * @return the price of gas at the gas station
     */
    public int getGasPrice() {
        return gasPrice;
    }

    /**
     * Sets the price of gas at the gas station to the specified value.
     *
     * @param gasPrice the new price of gas at the gas station
     */
    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    /**
     * Returns a string representation of the GasStation object.
     *
     * @return a string representation of the GasStation object
     */
    @Override
    public String toString() {
        return "GasStation{" + "name=" + getName() + ", X=" + getX() + ", Y=" + getY() + ", gasPrice=" + gasPrice + '}';
    }

    /**
     * Compares this GasStation object to the specified object for equality.
     *
     * @param o the object to compare to this GasStation object
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasStation that = (GasStation) o;
        return gasPrice == that.gasPrice;
    }
}