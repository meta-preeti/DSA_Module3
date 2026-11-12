/**
 * Implementation of a Singly Linked List.
 * Supports insertion, display and cycle detection.
 */
public class LinkedList {


    Node head;


    /**
     * Inserts a node at the end of the list.
     *
     * @param data value to be inserted
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
     * (Works only if there is no cycle.)
     */
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    /**
     * Detects the starting node of the cycle.
     * @return starting node of cycle,
     *         or null if no cycle exists
     */
    public Node detectCycle() {


        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                Node ptr1 = head;
                Node ptr2 = slow;

                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }

                return ptr1;
            }
        }


        return null;
    }
}