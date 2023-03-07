/**
 * The City class represents a city with a name, coordinates, and population.
 */
public class City extends Location {
    /**
     * The population of the city.
     */
    private int population;

    /**
     * Creates a new City object with the specified name, coordinates, and population.
     *
     * @param name the name of the city
     * @param x the x coordinate of the city
     * @param y the y coordinate of the city
     * @param population the population of the city
     */
    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }

    /**
     * Returns the population of the city.
     *
     * @return the population of the city
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the population of the city to the specified value.
     *
     * @param population the new population of the city
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Returns a string representation of the City object.
     *
     * @return a string representation of the City object
     */
    @Override
    public String toString() {
        return "City{" + "name=" + getName() + ", X=" + getX() + ", Y=" + getY() + ", population=" + population + '}';
    }

    /**
     * Compares this City object to the specified object for equality.
     *
     * @param o the object to compare to this City object
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population;
    }
}