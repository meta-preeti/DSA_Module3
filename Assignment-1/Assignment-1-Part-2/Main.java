/**
 * Driver class to test cycle detection.
 */
public class Main {


    public static void main(String[] args) {


        
        // Test Case 1 : Without Cycle
        LinkedList list1 = new LinkedList();


        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(40);
        list1.insert(50);


        System.out.println("Linked List - 1:");
        list1.display();


        Node result1 = list1.detectCycle();


        if (result1 == null) {
            System.out.println("No Cycle Found");
        } else {
            System.out.println("Cycle starts at node : " + result1.data);
        }


        System.out.println();


        // Test Case 2 : With Cycle
        LinkedList list2 = new LinkedList();

        list2.insert(10);
        list2.insert(20);
        list2.insert(30);
        list2.insert(40);
        list2.insert(50);
        
         

        // Creating cycle manually
        Node temp = list2.head;

        while (temp.next != null) {
            temp = temp.next;
        }
        // Last node (50) points to node 30
        temp.next = list2.head.next.next;

        Node result2 = list2.detectCycle();

        if (result2 == null) {
            System.out.println("No Cycle Found");
        } else {
            System.out.println("Cycle starts at node : " + result2.data);
        }
    }
}