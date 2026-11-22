/**
 * Manages the leaderboard using a Doubly Linked List.
 */
public class Leaderboard {


    private Node head;
    private Node tail;


    /**
     * Creates an empty leaderboard.
     */
    public Leaderboard() {
        head = null;
        tail = null;
    }


    /**
     * Inserts a new player into the leaderboard.
     *
     * @param registrationId Unique registration ID.
     * @param playerName Name of the player.
     * @param score Score of the player.
     * @throws IllegalArgumentException If registration ID already exists.
     */
    public void insertPlayer(int registrationId, String playerName, int score) {


        if (containsRegistrationId(registrationId)) {
            throw new IllegalArgumentException(
                    "Registration ID already exists.");
        }


        Node newNode = new Node(registrationId, playerName, score);


        // If the list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }


        // Insert at the end
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }


    /**
     * Displays all players in the leaderboard.
     */
    public void displayLeaderboard() {


        if (head == null) {
            System.out.println("Leaderboard is empty.");
            return;
        }


        Node current = head;


        System.out.println("\nLeaderboard");
        System.out.println("-------------------------");
        System.out.println("ID\tName\tScore");
        System.out.println("-------------------------");


        while (current != null) {


            System.out.println(current.registrationId + "\t"
                    + current.playerName + "\t"
                    + current.score);


            current = current.next;
        }


        System.out.println("-------------------------");
    }


    /**
     * Checks whether a registration ID already exists.
     *
     * @param registrationId Registration ID to search.
     * @return true if the ID exists, otherwise false.
     */
    private boolean containsRegistrationId(int registrationId) {


        Node current = head;


        while (current != null) {


            if (current.registrationId == registrationId) {
                return true;
            }


            current = current.next;
        }


        return false;
    }

     /**
 * Swaps two adjacent nodes in the doubly linked list.
 *
 * @param first  First node.
 * @param second Second node (must be first.next).
 */
private void swapAdjacentNodes(Node first, Node second) {


    Node previousNode = first.prev;
    Node nextNode = second.next;


    // Connect previous node with second
    if (previousNode != null) {
        previousNode.next = second;
    } else {
        head = second;
    }


    second.prev = previousNode;


    // Connect second with first
    second.next = first;
    first.prev = second;


    // Connect first with next node
    first.next = nextNode;


    if (nextNode != null) {
        nextNode.prev = first;
    } else {
        tail = first;
    }
}

/**
 * Sorts the leaderboard in descending order of score.
 * If scores are equal, player with smaller registration ID comes first.
 */
public void bubbleSort() {


    if (head == null || head.next == null) {
        return;
    }


    boolean swapped;


    do {


        swapped = false;
        Node current = head;


        while (current != null && current.next != null) {


            Node nextNode = current.next;


            if (current.score < nextNode.score ||
               (current.score == nextNode.score &&
                current.registrationId > nextNode.registrationId)) {


                swapAdjacentNodes(current, nextNode);
                swapped = true;


                // After swapping, start again from head
                current = head;
            } else {
                current = current.next;
            }
        }


    } while (swapped);
}

}