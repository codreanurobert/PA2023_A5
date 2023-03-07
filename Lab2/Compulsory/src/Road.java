public class Road {
    private String name;
    private RoadType type;
    private double length;
    private int speedLimit;
    private Location source;
    private Location destination;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Road(String name, RoadType type, int speedLimit, double length,Location source, Location destination) {
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
