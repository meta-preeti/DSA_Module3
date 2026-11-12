/**
 * Represents a node of a singly linked list.
 * Each node stores an integer value and a reference
 * to the next node in the list.
 */
public class Node {


    /** Data stored in the node. */
    int data;

    /** Reference to the next node. */
    Node next;


    /**
     * Creates a new node with the given data.
     *
     * @param data Value to be stored in the node.
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}