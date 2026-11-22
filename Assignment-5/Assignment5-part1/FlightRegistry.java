import java.util.List;
import java.util.ArrayList ;


 /* Manages the Flight Registry using a Binary Search Tree (BST).
 * Supports insertion of flight records into the registry.
 */
public class FlightRegistry {


    /** Root node of the Binary Search Tree. */
    private Node root;


    /**
     * Creates a Flight Registry and inserts all initial flights
     * into the Binary Search Tree.
     *
     * @param flights List of initial flight records.
     */
    public FlightRegistry(List<Flight> flights) {


        root = null;


        // Handle null or empty input list
        if (flights == null || flights.isEmpty()) {
            return;
        }


        // Insert each flight into the BST
        for (Flight flight : flights) {
            insert(flight);
        }
    }


    /**
     * Inserts a flight into the registry.
     *
     * @param flight Flight record to insert.
     */
    public void insert(Flight flight) {
        root = insert(root, flight);
    }


    /**
     * Recursively inserts a flight into the BST.
     *
     * @param current Current node being processed.
     * @param flight Flight to be inserted.
     * @return Updated subtree root.
     */
    private Node insert(Node current, Flight flight) {


        // Empty position found
        if (current == null) {
            return new Node(flight);
        }


        // Insert into left subtree
        if (flight.getFlightNumber() < current.flight.getFlightNumber()) {


            current.left = insert(current.left, flight);


        }


        // Insert into right subtree
        else if (flight.getFlightNumber() > current.flight.getFlightNumber()) {


            current.right = insert(current.right, flight);


        }


        // Duplicate flight number
        else {
            System.out.println("Flight Number already exists.");
        }


        return current;
    }


    /**
 * Searches for a flight using its flight number.
 *
 * @param flightNumber Flight number to search.
 * @return Flight object if found, otherwise null.
 */
public Flight getDepartureTime(int flightNumber) {


    Node node = search(root, flightNumber);


    if (node == null) {
        return null;
    }


    return node.flight;
}


/**
 * Recursively searches a flight in the BST.
 *
 * @param current Current node being processed.
 * @param flightNumber Flight number to search.
 * @return Matching node if found, otherwise null.
 */
private Node search(Node current, int flightNumber) {


    // Flight not found
    if (current == null) {
        return null;
    }


    // Flight found
    if (flightNumber == current.flight.getFlightNumber()) {
        return current;
    }


    // Search in left subtree
    if (flightNumber < current.flight.getFlightNumber()) {
        return search(current.left, flightNumber);
    }


    // Search in right subtree
    return search(current.right, flightNumber);
}


/**
 * Deletes a flight from the registry.
 *
 * @param flightNumber Flight number to delete.
 */
public void delete(int flightNumber) {
    root = delete(root, flightNumber);
}


/**
 * Recursively deletes a flight from the BST.
 *
 * @param current Current node.
 * @param flightNumber Flight number to delete.
 * @return Updated subtree root.
 */
private Node delete(Node current, int flightNumber) {


    // Flight not found
    if (current == null) {
        return null;
    }


    // Search in left subtree
    if (flightNumber < current.flight.getFlightNumber()) {
        current.left = delete(current.left, flightNumber);
    }


    // Search in right subtree
    else if (flightNumber > current.flight.getFlightNumber()) {
        current.right = delete(current.right, flightNumber);
    }


    // Flight found
    else {


        // Case 1 : No child
        if (current.left == null && current.right == null) {
            return null;
        }


        // Case 2 : Only right child
        if (current.left == null) {
            return current.right;
        }


        // Case 2 : Only left child
        if (current.right == null) {
            return current.left;
        }


        // Case 3 : Two children
        Node successor = findMin(current.right);


        current.flight = successor.flight;


        current.right = delete(current.right,
                successor.flight.getFlightNumber());
    }


    return current;
}


/**
 * Returns the node having the minimum flight number
 * in a subtree.
 *
 * @param current Root of the subtree.
 * @return Node with the minimum flight number.
 */
private Node findMin(Node current) {


    while (current.left != null) {
        current = current.left;
    }


    return current;
}


/**
 * Returns all flights in descending order of flight number.
 *
 * @return List of flights in descending order.
 */
public List<Flight> getAllFlightsDescending() {


    List<Flight> flights = new ArrayList<>();


    reverseInorder(root, flights);


    return flights;
}


/**
 * Performs reverse inorder traversal.
 * (Right -> Root -> Left)
 *
 * @param current Current node.
 * @param flights List storing the result.
 */
private void reverseInorder(Node current, List<Flight> flights) {


    if (current == null) {
        return;
    }


    reverseInorder(current.right, flights);


    flights.add(current.flight);


    reverseInorder(current.left, flights);
}


/**
 * Returns all flights whose flight numbers lie
 * strictly between the given bounds.
 *
 * @param lowerBound Lower exclusive bound.
 * @param upperBound Upper exclusive bound.
 * @return List of matching flights.
 */
public List<Flight> getFlightsBetween(int lowerBound, int upperBound) {


    List<Flight> flights = new ArrayList<>();


    if (lowerBound >= upperBound) {
        return flights;
    }


    rangeSearch(root, lowerBound, upperBound, flights);


    return flights;
}


/**
 * Performs an optimized inorder traversal to
 * collect flights lying within the given range.
 *
 * @param current Current node.
 * @param lowerBound Lower exclusive bound.
 * @param upperBound Upper exclusive bound.
 * @param flights Result list.
 */
private void rangeSearch(Node current,
                         int lowerBound,
                         int upperBound,
                         List<Flight> flights) {


    if (current == null) {
        return;
    }


    // Visit left subtree only if required
    if (current.flight.getFlightNumber() > lowerBound) {
        rangeSearch(current.left, lowerBound, upperBound, flights);
    }


    // Current node lies inside the range
    if (current.flight.getFlightNumber() > lowerBound
            && current.flight.getFlightNumber() < upperBound) {


        flights.add(current.flight);
    }


    // Visit right subtree only if required
    if (current.flight.getFlightNumber() < upperBound) {
        rangeSearch(current.right, lowerBound, upperBound, flights);
    }
}

}