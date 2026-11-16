/**
 * Represents a Priority Queue.
 *
 * This class stores the head node and the
 * total number of items present in the queue.
 *
 * All queue operations are implemented in
 * PriorityQueueOperation.java
 */
public class PriorityQueue {

    /**
     * Points to the first node of the queue.
     */
    protected Node head;


    /**
     * Stores the total number of items
     * present in the queue.
     */
    protected int size;


    /**
     * Creates an empty Priority Queue.
     */
    public PriorityQueue() {
        // Initially, the queue is empty.
        head = null;

        // Initially, there are no items.
        size = 0;
    }
}