/**
 * Represents a weighted edge in an undirected graph.
 * Each edge stores its source vertex, destination vertex,
 * and the weight between them.
 */
public class Edge implements Comparable<Edge> {


    /** Source vertex of the edge. */
    private int source;

    /** Destination vertex of the edge. */
    private int destination;

    /** Weight of the edge. */
    private int weight;


/**
 * Creates a new edge.
 *
 * @param source Source vertex
 * @param destination Destination vertex
 * @param weight Weight of the edge
 * @throws IllegalArgumentException if source, destination or weight is invalid
 */
public Edge(int source, int destination, int weight) {


    if (source < 0) {
        throw new IllegalArgumentException("Source vertex cannot be negative.");
    }


    if (destination < 0) {
        throw new IllegalArgumentException("Destination vertex cannot be negative.");
    }


    if (weight < 0) {
        throw new IllegalArgumentException("Edge weight cannot be negative.");
    }


    if (source == destination) {
        throw new IllegalArgumentException("Self-loops are not allowed.");
    }


    this.source = source;
    this.destination = destination;
    this.weight = weight;
}

    /**
     * Returns the source vertex.
     *
     * @return source vertex
     */
    public int getSource() {
        return source;
    }


    /**
     * Returns the destination vertex.
     *
     * @return destination vertex
     */
    public int getDestination() {
        return destination;
    }


    /**
     * Returns the weight of the edge.
     *
     * @return edge weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Compares two edges based on their weight.
     * Used while sorting edges for Kruskal's algorithm.
     *
     * @param other Another edge
     * @return negative, zero, or positive value depending on comparison
     */
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}