import java.util.Objects;
/**
 * The Location class represents a location with a name and x and y coordinates.
 */
public abstract class Location {
    /**
     * The name of the location.
     */
    private String name;
    /**
     * The x coordinate of the location.
     */
    private double x;
    /**
     * The y coordinate of the location.
     */
    private double y;
    /**
     * Creates a new Location object with the specified name, x, and y coordinates.
     *
     * @param name the name of the location
     * @param x the x coordinate of the location
     * @param y the y coordinate of the location
     */
    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    /**
     * Returns the name of the location.
     *
     * @return the name of the location
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the location to the specified value.
     *
     * @param name the new name of the location
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the x coordinate of the location.
     *
     * @return the x coordinate of the location
     */
    public double getX() {
        return x;
    }
    /**
     * Sets the x coordinate of the location to the specified value.
     *
     * @param x the new x coordinate of the location
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Returns the y coordinate of the location.
     *
     * @return the y coordinate of the location
     */
    public double getY() {
        return y;
    }
    /**
     * Sets the y coordinate of the location to the specified value.
     *
     * @param y the new y coordinate of the location
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Returns the distance between this location and the specified location.
     *
     * @param location the location to calculate the distance to
     * @return the distance between this location and the specified location
     */
    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", X=" + x + ", Y=" + y + "}";
    }
    /**
     * Compares this Location object to the specified object for equality.
     *
     * @param o the object to compare to this Location object
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0 && Objects.equals(name, location.name);
    }
}

