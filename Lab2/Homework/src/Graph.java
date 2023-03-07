import java.util.*;

/**
 * The Graph class represents a graph of locations.
 */
public class Graph {
    /**
     * The adjacency list of the graph.
     */
    private Map<String, List<String>> adjacencyList;

    /**
     * Creates a new Graph object.
     */
    public Graph() {
        adjacencyList = new HashMap<>();
    }
    /**
     * Adds an edge between the specified source and destination.
     *
     * @param source the source of the edge
     * @param destination the destination of the edge
     */
    public void addEdge(String source, String destination) {
        if (!adjacencyList.containsKey(source)) {
            adjacencyList.put(source, new ArrayList<>());
        }
        adjacencyList.get(source).add(destination);

        if (!adjacencyList.containsKey(destination)) {
            adjacencyList.put(destination, new ArrayList<>());
        }
        adjacencyList.get(destination).add(source);
    }

    /**
     * Returns true if there is a path between the specified source and destination, and false otherwise.
     *
     * @param source the source of the path
     * @param destination the destination of the path
     * @return true if there is a path between the specified source and destination, and false otherwise
     */
    public boolean hasPath(String source, String destination) {
        Set<String> visited = new HashSet<>();
        return hasPathDFS(source, destination, visited);
    }

    /**
     * Returns true if there is a path between the specified source and destination, and false otherwise.
     *
     * @param source the source of the path
     * @param destination the destination of the path
     * @param visited the set of visited locations
     * @return true if there is a path between the specified source and destination, and false otherwise
     */
    private boolean hasPathDFS(String source, String destination, Set<String> visited) {
        if (source.equals(destination)) {
            return true;
        }

        visited.add(source);
        if (!adjacencyList.containsKey(source)) {
            return false;
        }

        for (String neighbor : adjacencyList.get(source)) {
            if (!visited.contains(neighbor)) {
                if (hasPathDFS(neighbor, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}