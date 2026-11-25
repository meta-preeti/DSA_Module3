import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Represents an undirected weighted graph using
 * Edge List and Adjacency List representations.
 */
public class Graph {


    /** Total number of vertices in the graph. */
    private int vertices;


    /** Stores all edges of the graph. */
    private List<Edge> edges;


    /** Stores the adjacency list representation of the graph. */
    private List<List<Edge>> adjacencyList;


    /**
     * Creates a graph with the given number of vertices.
     *
     * @param vertices Total number of vertices
     * @throws IllegalArgumentException if number of vertices is invalid
     */
    public Graph(int vertices) {
        if (vertices <= 0) {
            throw new IllegalArgumentException(
                    "Number of vertices must be greater than zero.");
        }

        this.vertices = vertices;

        edges = new ArrayList<>();

        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }


    /**
     * Adds an undirected weighted edge to the graph.
     *
     * @param source Source vertex
     * @param destination Destination vertex
     * @param weight Weight of the edge
     * @throws IllegalArgumentException if any input is invalid
     */
    public void addEdge(int source, int destination, int weight) {

        if (source < 0 || source >= vertices) {
            throw new IllegalArgumentException("Invalid source vertex.");
        }


        if (destination < 0 || destination >= vertices) {
            throw new IllegalArgumentException("Invalid destination vertex.");
        }


        if (source == destination) {
            throw new IllegalArgumentException("Self-loops are not allowed.");
        }


        if (weight < 0) {
            throw new IllegalArgumentException("Edge weight cannot be negative.");
        }


        // Check for duplicate edge
        for (Edge edge : edges) {


            if ((edge.getSource() == source
                    && edge.getDestination() == destination)
                    || (edge.getSource() == destination
                    && edge.getDestination() == source)) {


                throw new IllegalArgumentException(
                        "Duplicate edge is not allowed.");
            }
        }


        Edge edge = new Edge(source, destination, weight);


        edges.add(edge);


        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination)
                .add(new Edge(destination, source, weight));
    }

/**
     * Performs Breadth First Search (BFS) from the given source vertex.
     *
     * @param source Starting vertex
     * @param visited Array to keep track of visited vertices
     * @return List of reachable vertices in BFS order
     */
    private List<Integer> bfs(int source, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> reachableVertices = new ArrayList<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            reachableVertices.add(current);

            for (Edge edge : adjacencyList.get(current)) {
                int neighbour = edge.getDestination();
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return reachableVertices;
    }


    /**
     * Returns all vertices reachable from the given source.
     *
     * @param source Starting vertex
     * @return List of reachable vertices
     * @throws IllegalArgumentException if source vertex is invalid
     */
    public List<Integer> reachable(int source) {
        if (source < 0 || source >= vertices) {
            throw new IllegalArgumentException("Invalid source vertex.");
        }

        boolean[] visited = new boolean[vertices];

        return bfs(source, visited);
    }


    /**
     * Checks whether the graph is connected.
     *
     * @return true if the graph is connected, otherwise false
     */
    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        int connectedComponents = 0;

        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!visited[vertex]) {
                bfs(vertex, visited);
                connectedComponents++;
                if (connectedComponents > 1) {
                    return false;
                }
            }
        }

        return true;
    }

/**
     * Constructs the Minimum Spanning Tree (MST)
     * using Kruskal's Algorithm.
     *
     * @return Graph representing the MST
     * @throws IllegalStateException if graph is disconnected
     */
    public Graph mst() {

        if (!isConnected()) {
            throw new IllegalStateException(
                    "Minimum Spanning Tree cannot be formed because the graph is disconnected.");
        }

        Graph mstGraph = new Graph(vertices);
        List<Edge> sortedEdges = new ArrayList<>(edges);
        Collections.sort(sortedEdges);

        DisjointSet disjointSet = new DisjointSet(vertices);


        for (Edge edge : sortedEdges) {
            int source = edge.getSource();
            int destination = edge.getDestination();

            if (disjointSet.find(source) != disjointSet.find(destination)) {
                mstGraph.addEdge(source, destination, edge.getWeight());
                disjointSet.union(source, destination);
            }
        }

        return mstGraph;
    }


    /**
     * Finds the shortest path between two vertices
     * using Dijkstra's Algorithm.
     *
     * @param source Starting vertex
     * @param destination Destination vertex
     * @return List containing the shortest path
     * @throws IllegalArgumentException if source or destination is invalid
     */
    public List<Integer> shortestPath(int source, int destination) {

        if (source < 0 || source >= vertices) {
            throw new IllegalArgumentException("Invalid source vertex.");
        }

        if (destination < 0 || destination >= vertices) {
            throw new IllegalArgumentException("Invalid destination vertex.");
        }

        if (source == destination) {
            List<Integer> path = new ArrayList<>();
            path.add(source);
            return path;
        }

        int[] distance = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> priorityQueue =  new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        distance[source] = 0;
        priorityQueue.offer(new int[]{source, 0});

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentVertex = current[0];
            int currentDistance = current[1];

            if (currentDistance > distance[currentVertex]) {
                continue;
            }

            for (Edge edge : adjacencyList.get(currentVertex)) {
                int neighbour = edge.getDestination();
                // Prevent integer overflow
                if (distance[currentVertex] == Integer.MAX_VALUE) {
                    continue;
                }

                int newDistance = distance[currentVertex] + edge.getWeight();
                if (newDistance < distance[neighbour]) {
                    distance[neighbour] = newDistance;
                    parent[neighbour] = currentVertex;
                    priorityQueue.offer(new int[]{neighbour, newDistance});
                }
            }
        }


        List<Integer> path = new ArrayList<>();

        if (distance[destination] == Integer.MAX_VALUE) {
            return path;
        }

        int current = destination;

        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);

        return path;
    }

/**
     * Displays all edges of the graph.
     */
    public void displayEdges() {


        if (edges.isEmpty()) {
            System.out.println("No edges present in the graph.");
            return;
        }

        for (Edge edge : edges) {
            System.out.println(edge.getSource()   + " -> " + edge.getDestination() + " (Weight: " + edge.getWeight() + ")");
        }
    }


    /**
     * Displays the graph in adjacency list form.
     */
    public void displayGraph() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print("("  + edge.getDestination()   + ", " + edge.getWeight() + ") ");
            }

            System.out.println();
        }
    }
}