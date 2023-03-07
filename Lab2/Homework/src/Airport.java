import java.util.Objects;

/**
 * The Airport class represents an airport with a name, x and y coordinates, and number of terminals.
 */
public class Airport extends Location{
    /**
     * The number of terminals at the airport.
     */
    int numberOfTerminals;

    /**
     * Creates a new Airport object with the specified name, coordinates, and number of terminals.
     *
     * @param name the name of the airport
     * @param x the x coordinate of the airport
     * @param y the y coordinate of the airport
     * @param numberOfTerminals the number of terminals at the airport
     */
    public Airport(String name, double x, double y, int numberOfTerminals) {
        super(name, x, y);
        this.numberOfTerminals = numberOfTerminals;
    }
    /**
     * Returns the number of terminals at the airport.
     *
     * @return the number of terminals at the airport
     */
    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    /**
     * Sets the number of terminals at the airport to the specified value.
     *
     * @param numberOfTerminals the new number of terminals at the airport
     */
    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
    /**
     * Returns a string representation of the Airport object.
     *
     * @return a string representation of the Airport object
     */
    @Override
    public String toString() {
        return "Airport{" + "name=" + getName() + ", X=" + getX() + ", Y=" + getY() + ", numberOfTerminals=" + numberOfTerminals + '}';
    }

    /**
     * Compares this Airport object to the specified object for equality.
     *
     * @param o the object to compare to this Airport object
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return numberOfTerminals == airport.numberOfTerminals;
    }


}
