/**
 * Represents a single node in the Priority Queue.
 *
 * Each node stores:
 * 1. Item
 * 2. Priority
 * 3. Reference to the next node
 */
public class Node {

    /**
     * Item stored in the node.
     */
    private String item;

    /**
     * Priority of the item.
     */
    private int priority;

    /**
     * Reference to the next node.
     */
    private Node next;


    /**
     * Creates a new node.
     * @param item Item to be stored.
     * @param priority Priority of the item.
     */
    public Node(String item, int priority) {

        // Store the item.
        this.item = item;

        // Store the priority.
        this.priority = priority;

        // Initially, the next node is null.
        this.next = null;
    }


    /**
     * Returns the item stored in the node.
     * @return Item name.
     */
    public String getItem() {
        return item;
    }


    /**
     * Updates the item stored in the node.
     * @param item New item.
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * Returns the priority of the node.
     *
     * @return Priority value.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Updates the priority of the node.
     * @param priority New priority.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Returns the next node.
     * @return Next node.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Updates the next node reference.
     * @param next Next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}