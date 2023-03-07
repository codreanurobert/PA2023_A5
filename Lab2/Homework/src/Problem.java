import java.util.ArrayList;

/**
 * The Problem class represents a problem to be solved.
 */
public class Problem {
    /**
     * The list of locations in the problem.
     */
    static ArrayList<Location> locations = new ArrayList<Location>();


    public static void main(String args[]) {

        Location C1 = new City("C1", 14, 15, 10321);
        Location C2 = new City("C2", 20, 11, 1111);
        Location A1 = new Airport("A1", 24, 53, 3);
        Location A2 = new Airport("A2", 32, 13, 5);
        Location G1 = new GasStation("G1", 12, 33, 7);
        Location G2 = new GasStation("G2", 3, 8, 8);


        addLocation(C1);
        addLocation(C2);
        addLocation(A1);
        addLocation(A2);
        addLocation(G1);
        addLocation(G2);

        Road R1 = new Road("R1", RoadType.HIGHWAY, 140, 100, C1, C2);
        Road R2 = new Road("R2", RoadType.EXPRESSROAD, 70, 113,C2, G1);
        Road R3 = new Road("R3", RoadType.COUNTRYROAD, 50, 214, C1, G2);
        Road R4 = new Road("R4", RoadType.COUNTRYROAD, 50, 214, G1, G2);
        Road R5 = new Road("R5", RoadType.COUNTRYROAD, 50, 214, G1, A1);

        System.out.println(C1);
        System.out.println(A2.getName());
        System.out.println(R2);
        System.out.println("Length of R3: " + R3.getLength() + " km");
        System.out.println("Speed limit of R1: " + R1.getSpeedLimit() + " km/h");

        if(isInstanceValid()) {
            for (int i = 0; i < locations.size(); i++) {
                System.out.println(locations.get(i));
            }
            //solveProblem();
            Graph graph = new Graph();
            graph.addEdge("C1", "C2");
            graph.addEdge("C2", "G1");
            graph.addEdge("C1", "G2");
            graph.addEdge("G1", "G2");
            graph.addEdge("G1", "A1");

            System.out.println(graph.hasPath("C1", "A1")); //true
            System.out.println(graph.hasPath("C2", "A2")); //false
        }
        else  {
            System.out.println("Instance is not valid");
        }
    }

    /**
     * Adds the specified location to the problem.
     *
     * @param l the location to be added
     */
    public static void addLocation(Location l) {
        boolean exists = false;

        for (Location element : locations) {
            if (element.equals(l)) {
                System.out.println("Location already exists");
                exists = true;
                break;
            }
        }
        if(exists == false)
            locations.add(l);
    }
    /**
     * Returns true if the problem instance is valid, and false otherwise.
     *
     * @return true if the problem instance is valid, and false otherwise
     */
    public static boolean isInstanceValid()
    {
        if(locations.size() < 3)
        {
            System.out.println("Instance is not valid");
            return false;
        }
        else
        {
            System.out.println("Instance is valid");
        }
        return true;
    }
    public static void solveProblem()
    {
        //ar fi fost prea complexa functia, am facut o clasa separata pentru operatia cu graf
    }
}
