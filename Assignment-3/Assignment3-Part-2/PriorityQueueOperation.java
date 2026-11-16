/**
 * Performs all Priority Queue operations.
 */
public class PriorityQueueOperation extends PriorityQueue {


    /**
     * Creates a Priority Queue.
     */
    public PriorityQueueOperation() {
        super();
    }


    /**
     * Validates the item entered by the user.
     *
     * @param item Item name.
     * @return true if the item is valid,
     * otherwise false.
     */
    private boolean isValidItem(String item) {


        // Check whether the item is null.
        if (item == null) {
            System.out.println("Invalid item.");
            return false;
        }


        // Remove leading and trailing spaces.
        item = item.trim();


        // Check whether the item is empty.
        if (item.isEmpty()) {
            System.out.println("Item cannot be empty.");
            return false;
        }


        return true;
    }


    /**
     * Returns the total number of items
     * present in the queue.
     *
     * @return Queue size.
     */
    public int size() {
        return size;
    }


    /**
     * Checks whether the queue is empty.
     *
     * @return true if the queue is empty,
     * otherwise false.
     */
    public boolean isEmpty() {
        return head == null;
    }


    /**
 * Checks whether the item already exists in the queue.
 *
 * @param item Item to be searched.
 * @return true if the item exists, otherwise false.
 */
private boolean isDuplicateItem(String item) {


    Node current = head;


    while (current != null) {


        if (current.getItem().equalsIgnoreCase(item)) {
            return true;
        }


        current = current.getNext();
    }


    return false;
}

    /**
 * Inserts a new item into the Priority Queue.
 *
 * The queue is maintained in descending order
 * of priority. If two items have the same
 * priority, they are stored in FIFO order.
 *
 * @param item Item to be inserted.
 * @param priority Priority of the item.
 */
public void insert(String item, int priority) {

    // Validate the item.
    if (!isValidItem(item)) {
        return;
    }

    // Remove leading and trailing spaces.
    item = item.trim();
    
    // Check whether the item already exists.
     if (isDuplicateItem(item)) {
        System.out.println("Item already exists.");
        return;
      }

    // Create a new node.
    Node newNode = new Node(item, priority);


    // Case 1 : Queue is empty.
    if (head == null) {

        head = newNode;
        size++;

        System.out.println("Item inserted successfully.");
        return;
    }


    // Case 2 : Insert before the head.
    if (priority > head.getPriority()) {

        newNode.setNext(head);
        head = newNode;
        size++;

        System.out.println("Item inserted successfully.");
        return;
    }


    // Traverse the queue.
    Node current = head;


    while (current.getNext() != null && current.getNext().getPriority() >= priority) {

        current = current.getNext();
    }


    // Insert the new node.
    newNode.setNext(current.getNext());
    current.setNext(newNode);
    size++;
    System.out.println("Item inserted successfully.");
}

/**
 * Removes and returns the highest priority item.
 *
 * @return Removed item, or null if the queue is empty.
 */
public String removeTop() {

    // Check whether the queue is empty.
    if (isEmpty()) {
        System.out.println("Priority Queue is empty.");
        return null;
    }


    // Store the item to be removed.
    String removedItem = head.getItem();

    // Move head to the next node.
    head = head.getNext();

    // Decrease the queue size.
    size--;

    System.out.println("Item removed successfully.");

    return removedItem;
}


/**
 * Returns the highest priority item
 * without removing it.
 *
 * @return Highest priority item,
 * or null if the queue is empty.
 */
public String peek() {

    // Check whether the queue is empty.
    if (isEmpty()) {
        System.out.println("Priority Queue is empty.");
        return null;
    }

    return head.getItem();
}

/**
 * Changes the priority of an existing item.
 *
 * @param item Item whose priority is to be changed.
 * @param newPriority New priority of the item.
 */
public void changePriority(String item, int newPriority) {


    // Validate the item.
    if (!isValidItem(item)) {
        return;
    }

    item = item.trim();

    Node current = head;
    Node previous = null;

    // Search for the item.
    while (current != null &&  !current.getItem().equalsIgnoreCase(item)) {

        previous = current;
        current = current.getNext();
    }

    // Item not found.
    if (current == null) {
        System.out.println("Item not found.");
        return;
    }


    // Remove the node from the queue.
    if (previous == null) {
        head = head.getNext();
    } else {
        previous.setNext(current.getNext());
    }

    // Decrease size because the node is removed.
    size--;

    // Insert again with new priority.
    insert(current.getItem(), newPriority);

    System.out.println("Priority updated successfully.");
}


}