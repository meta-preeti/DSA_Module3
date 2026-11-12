/**
 * Implementation of a Singly Linked List.
 * Supports insertion, display and left rotation
 * of a sublist.
 *
 */
public class LinkedList {


    /** Head node of the linked list. */
    private Node head;


    /**
     * Inserts a new node at the end of the linked list.
     *
     * @param data value to be inserted.
     */
    public void insert(int data) {


        Node newNode = new Node(data);


        if (head == null) {
            head = newNode;
            return;
        }


        Node temp = head;


        while (temp.next != null) {
            temp = temp.next;
        }


        temp.next = newNode;
    }


    /**
     * Displays the linked list.
     */
    public void display() {


        if (head == null) {
            System.out.println("List is empty.");
            return;
        }


        Node temp = head;


        while (temp != null) {
            System.out.print(temp.data);


            if (temp.next != null) {
                System.out.print(" -> ");
            }


            temp = temp.next;
        }


        System.out.println();
    }


    /**
     * Returns the size of the linked list.
     *
     * @return number of nodes.
     */
    public int size() {


        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }


    /**
     * Rotates the sublist from position L to R
     * in left direction by N positions.
     *
     * @param L starting position (1-based)
     * @param R ending position (1-based)
     * @param N number of left rotations
     */
    public void rotateSubList(int L, int R, int N) {


        // Edge Case 1 : Empty List
        if (head == null) {
            return;
        }


        // Edge Case 2 : Invalid positions
        if (L >= R || L <= 0 || R > size()) {
            return;
        }


        // Step 1 : Find beforeL and start node


        Node beforeL = null;
        Node start = head;


        int position = 1;


        while (start != null && position < L) {
            beforeL = start;
            start = start.next;
            position++;
        }


        // Safety check
        if (start == null) {
            return;
        }



        // Step 2 : Find end node and afterR node


        Node end = start;
        int subListLength = 1;


        while (end != null && subListLength < (R - L + 1)) {
            end = end.next;
            subListLength++;
        }


        if (end == null) {
            return;
        }


        Node afterR = end.next;


        // Step 3 : Handle large N
        N = N % subListLength;


        // No rotation needed
        if (N == 0) {
            return;
        }


        // Step 4 : Find newStart and newEnd


        Node newEnd = start;


        for (int i = 1; i < N; i++) {
            newEnd = newEnd.next;
        }


        Node newStart = newEnd.next;


        // Break the sublist
        newEnd.next = null;


        // Connect old end with old start
        end.next = start;


        // Connect left part
        if (beforeL != null) {
            beforeL.next = newStart;
        } else {
            head = newStart;
        }


        // Connect rotated part with remaining list
        start.next = afterR;
    }


    /**
     * Returns the head node.
     *
     * @return head of the linked list.
     */
    public Node getHead() {
        return head;
    }
}