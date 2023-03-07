/**
 * The Road class represents a road with a name, type, length, speed limit, source, and destination.
 */
public class Road {
    private String name;
    private RoadType type;
    private double length;
    private int speedLimit;
    private Location source;
    private Location destination;

    /**
     * Creates a new Road object with the specified name, type, length, speed limit, source, and destination.
     *
     * @param name the name of the road
     * @param type the type of the road
     * @param length the length of the road
     * @param speedLimit the speed limit of the road
     * @param source the source of the road
     * @param destination the destination of the road
     */
    public Road(String name, RoadType type, int speedLimit, double length, Location source, Location destination) {
        this.name = name;
        this.type = type;
        this.length = Math.sqrt(Math.pow(source.getX() - destination.getX(), 2) + Math.pow(source.getY() - destination.getY(), 2));
        this.speedLimit = speedLimit;
        this.source = source;
        this.destination = destination;

        if (length < Math.sqrt(Math.pow(source.getX() - destination.getX(), 2) + Math.pow(source.getY() - destination.getY(), 2))) {
            throw new IllegalArgumentException("The length of a road should not be less than the euclidian distance between the location coordinates.");
        }
    }

    /**
     * Returns the name of the road.
     *
     * @return the name of the road
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the road to the specified value.
     *
     * @param name the new name of the road
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the type of the road.
     *
     * @return the type of the road
     */
    public RoadType getType() {
        return type;
    }
    /**
     * Sets the type of the road to the specified value.
     *
     * @param type the new type of the road
     */
    public void setType(RoadType type) {
        this.type = type;
    }
    /**
     * Returns the length of the road.
     *
     * @return the length of the road
     */

    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the road to the specified value.
     *
     * @param length the new length of the road
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns the speed limit of the road.
     *
     * @return the speed limit of the road
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Sets the speed limit of the road to the specified value.
     *
     * @param speedLimit the new speed limit of the road
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * Returns the source of the road.
     *
     * @return the source of the road
     */
    public Location getSource() {
        return source;
    }

    /**
     * Sets the source of the road to the specified value.
     *
     * @param source the new source of the road
     */
    public void setSource(Location source) {
        this.source = source;
    }

    /**
     * Returns the destination of the road.
     *
     * @return the destination of the road
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * Sets the destination of the road to the specified value.
     *
     * @param destination the new destination of the road
     */
    public void setDestination(Location destination) {
        this.destination = destination;
    }



    /**
     * Returns a string representation of the road.
     *
     * @return a string representation of the road
     */
    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", source=" + source +
                ", destination=" + destination +
                "}";
    }

}
