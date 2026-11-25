import java.util.List;


/**
 * Driver class to test all graph operations.
 */
public class Main {


    /**
     * Main method of the program.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {


        try {

            // Create a graph with 6 vertices
            Graph graph = new Graph(6);

            // Add edges
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 2);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 5);
            graph.addEdge(2, 3, 8);
            graph.addEdge(2, 4, 10);
            graph.addEdge(3, 4, 2);
            graph.addEdge(3, 5, 6);
            graph.addEdge(4, 5, 3);

            System.out.println("===== EDGE LIST =====");
            graph.displayEdges();

            System.out.println();

            System.out.println("===== ADJACENCY LIST =====");
            graph.displayGraph();

            System.out.println();

            System.out.println("===== CONNECTED GRAPH =====");
            if (graph.isConnected()) {
                System.out.println("Graph is connected.");
            } else {
                System.out.println("Graph is not connected.");
            }


            System.out.println();


            System.out.println("===== REACHABLE VERTICES FROM 0 =====");
            List<Integer> reachableVertices = graph.reachable(0);
            System.out.println(reachableVertices);

            System.out.println();

            System.out.println("===== MINIMUM SPANNING TREE =====");
            Graph mstGraph = graph.mst();
            mstGraph.displayEdges();

            System.out.println();

            System.out.println("===== SHORTEST PATH FROM 0 TO 5 =====");
            List<Integer> shortestPath = graph.shortestPath(0, 5);
            System.out.println(shortestPath);


        } catch (IllegalArgumentException exception) {


            System.out.println("Invalid Input: " + exception.getMessage());


        } catch (IllegalStateException exception) {


            System.out.println("Operation Failed: "   + exception.getMessage());


        } catch (Exception exception) {


            System.out.println("Unexpected Error: " + exception.getMessage());
        }
    }
}