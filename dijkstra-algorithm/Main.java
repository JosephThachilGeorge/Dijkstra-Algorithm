/**
 * Includes the Main-Class
 *
 * @author Joseph Thachil George 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import dijkstra.*;

/**
 * Class handling the application flow.
 * It is used for demonstration purposes.
 */
public class Main {
    private static List<Vertex> vertices = new ArrayList<Vertex>();
    private static List<Edge> edges = new ArrayList<Edge>();

    /**
     * Adds a vertex to the list of vertices.
     *
     * @param name Name of the vertex
     */
    private static void addVertex(String name) {
        Vertex vertex = new Vertex(name);
        vertices.add(vertex);
    }

    /**
     * Creates an edge based on two given vertices and adds it to the list
     * of edges.
     *
     * @param origin Representing the edges origin
     * @param target Representing the edges target
     * @param weight Representing the edges weight
     */
    private static void addEdge(Vertex origin, Vertex target, int weight) {
        Edge edge = new Edge(origin, target, weight);
        edges.add(edge);
    }

    /**
     * Searches for a specific vertex in a given list of vertices and returns it.
     *
     * @param name Name of the vertex searched for
     * @param vertices List of vertices sifted through
     * @return vertex object searched for
     */
    private static Vertex findByName(String name, List<Vertex> vertices) {
        for (Vertex vertex : vertices) {
            if (vertex.getName().equals(name)) {
                return vertex;
            }
        }

        throw new RuntimeException("Error");
    }

    /**
     * Main-method called from the command line.
     *
     * @param args Command line input
     **/
    public static void main(String... args) {
        addVertex("A");
        addVertex("B");
        addVertex("C");
        addVertex("D");
        addVertex("E");
        addVertex("F");
        addVertex("G");
        addVertex("H");
        addVertex("I");
        addVertex("J");

        addEdge(findByName("A", vertices), findByName("B", vertices), 85);
        addEdge(findByName("B", vertices), findByName("C", vertices), 80);
        addEdge(findByName("C", vertices), findByName("D", vertices), 250);
        addEdge(findByName("D", vertices), findByName("E", vertices), 84);
        addEdge(findByName("A", vertices), findByName("F", vertices), 217);
        addEdge(findByName("F", vertices), findByName("G", vertices), 186);
        addEdge(findByName("F", vertices), findByName("H", vertices), 103);
        addEdge(findByName("I", vertices), findByName("H", vertices), 183);
        addEdge(findByName("H", vertices), findByName("E", vertices), 167);
        addEdge(findByName("A", vertices), findByName("J", vertices), 173);
        addEdge(findByName("J", vertices), findByName("E", vertices), 502);


        Graph graph = new Graph(vertices, edges);
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.runDijkstraRun(findByName("A", vertices));
        LinkedList<Vertex> path = dijkstra.findPath(findByName("E", vertices));

        for (Vertex vertex : path) {
            System.out.println(vertex.getName());
        }
    }
}
