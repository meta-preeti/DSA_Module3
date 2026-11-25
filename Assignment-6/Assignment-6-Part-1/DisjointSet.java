/**
 * Implements the Disjoint Set (Union-Find) data structure.
 * It is used in Kruskal's Algorithm to detect cycles while
 * constructing the Minimum Spanning Tree (MST).
 */
public class DisjointSet {


    /** Stores the parent of each vertex. */
    private int[] parent;


    /** Stores the rank (height) of each set. */
    private int[] rank;


    /**
     * Creates a disjoint set with the given number of vertices.
     *
     * @param vertices Total number of vertices
     * @throws IllegalArgumentException if number of vertices is invalid
     */
    public DisjointSet(int vertices) {


        if (vertices <= 0) {
            throw new IllegalArgumentException(
                    "Number of vertices must be greater than zero.");
        }


        parent = new int[vertices];
        rank = new int[vertices];


        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }


    /**
     * Finds the representative (parent) of a set.
     * Uses path compression for optimization.
     *
     * @param vertex Vertex whose parent is to be found
     * @return Representative of the set
     * @throws IllegalArgumentException if vertex is invalid
     */
    public int find(int vertex) {


        if (vertex < 0 || vertex >= parent.length) {
            throw new IllegalArgumentException("Invalid vertex.");
        }


        if (parent[vertex] == vertex) {
            return vertex;
        }


        parent[vertex] = find(parent[vertex]);
        return parent[vertex];
    }


    /**
     * Merges two sets using union by rank.
     *
     * @param first First vertex
     * @param second Second vertex
     * @throws IllegalArgumentException if any vertex is invalid
     */
    public void union(int first, int second) {


        if (first < 0 || first >= parent.length) {
            throw new IllegalArgumentException("Invalid first vertex.");
        }


        if (second < 0 || second >= parent.length) {
            throw new IllegalArgumentException("Invalid second vertex.");
        }


        int firstParent = find(first);
        int secondParent = find(second);


        if (firstParent == secondParent) {
            return;
        }


        if (rank[firstParent] < rank[secondParent]) {


            parent[firstParent] = secondParent;


        } else if (rank[firstParent] > rank[secondParent]) {


            parent[secondParent] = firstParent;


        } else {


            parent[secondParent] = firstParent;
            rank[firstParent]++;
        }
    }
}