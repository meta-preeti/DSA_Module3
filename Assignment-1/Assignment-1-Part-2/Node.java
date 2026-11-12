/**
 * Represents a node of a singly linked list.
 */
public class Node {


    // Stores the data
    int data;


    // Reference to the next node
    Node next;


    /**
     * Creates a new node.
     *
     * @param data value to be stored in the node
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}