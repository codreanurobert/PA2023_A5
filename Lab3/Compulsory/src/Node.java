public interface Node {
    String getName();
    //the interface may contain other abstract methods
    int getId();
    //or even default methods
    default double getWeight() {
        return 0.0;
    }

}