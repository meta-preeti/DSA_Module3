/**
 * Linked List for storing network packets.
 */
public class PacketLinkedList {


    private Packet head;


    /**
     * Creates an empty linked list.
     */
    public PacketLinkedList() {
        head = null;
    }


    /**
     * Inserts a packet at the end of the linked list.
     *
     * @param newPacket Packet to be inserted.
     * @throws IllegalArgumentException if packet is null.
     */
    public void insert(Packet newPacket) {


        if (newPacket == null) {
            throw new IllegalArgumentException("Packet cannot be null.");
        }


        if (head == null) {
            head = newPacket;
            return;
        }


        Packet current = head;


        while (current.next != null) {
            current = current.next;
        }


        current.next = newPacket;
    }


    /**
     * Prints all packets in the linked list.
     */
    public void print() {


        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }


        Packet current = head;


        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }


    /**
     * Returns true if packet 'a' should come before packet 'b'.
     *
     * Sorting Order:
     * 1. Payload Size -> Ascending
     * 2. Priority -> Descending
     */
    private boolean comesBefore(Packet a, Packet b) {


        if (a.getPayloadSize() < b.getPayloadSize()) {
            return true;
        }


        if (a.getPayloadSize() > b.getPayloadSize()) {
            return false;
        }


        return a.getPriority() > b.getPriority();
    }


    /**
     * Sorts the linked list using Quick Sort.
     *
     * @throws IllegalStateException if the linked list is empty.
     */
    public void sort() {


        if (head == null) {
            throw new IllegalStateException("Cannot sort an empty linked list.");
        }


        if (head.next == null) {
            return;
        }


        head = quickSort(head);
    }


/**
 * Performs Quick Sort on the linked list.
 *
 * @param head Head of the linked list.
 * @return Head of the sorted linked list.
 */
private Packet quickSort(Packet head) {


    if (head == null || head.next == null) {
        return head;
    }


    Packet pivot = head;


    Packet lessHead = null;
    Packet lessTail = null;


    Packet equalHead = null;
    Packet equalTail = null;


    Packet greaterHead = null;
    Packet greaterTail = null;


    Packet current = head;


    while (current != null) {


        Packet nextNode = current.next;
        current.next = null;


        if (comesBefore(current, pivot)) {


            if (lessHead == null) {
                lessHead = current;
                lessTail = current;
            } else {
                lessTail.next = current;
                lessTail = current;
            }


        } else if (comesBefore(pivot, current)) {


            if (greaterHead == null) {
                greaterHead = current;
                greaterTail = current;
            } else {
                greaterTail.next = current;
                greaterTail = current;
            }


        } else {


            if (equalHead == null) {
                equalHead = current;
                equalTail = current;
            } else {
                equalTail.next = current;
                equalTail = current;
            }


        }


        current = nextNode;
    }


    lessHead = quickSort(lessHead);
    greaterHead = quickSort(greaterHead);


    return concatenate(lessHead, equalHead, greaterHead);
}


/**
 * Concatenates three linked lists:
 * Less -> Equal -> Greater
 *
 * @param less Head of less list.
 * @param equal Head of equal list.
 * @param greater Head of greater list.
 * @return Head of merged list.
 */
private Packet concatenate(Packet less, Packet equal, Packet greater) {


    Packet newHead = null;
    Packet tail = null;


    if (less != null) {
        newHead = less;
        tail = getTail(less);
    }


    if (equal != null) {


        if (newHead == null) {
            newHead = equal;
            tail = getTail(equal);
        } else {
            tail.next = equal;
            tail = getTail(equal);
        }
    }


    if (greater != null) {


        if (newHead == null) {
            newHead = greater;
        } else {
            tail.next = greater;
        }
    }


    return newHead;
}


/**
 * Returns the last node of a linked list.
 *
 * @param head Head of the linked list.
 * @return Tail node.
 */
private Packet getTail(Packet head) {


    if (head == null) {
        return null;
    }


    while (head.next != null) {
        head = head.next;
    }


    return head;
}     
}