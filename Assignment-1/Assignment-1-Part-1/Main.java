/**
 * Driver class to test Linked List rotation.
 */
public class Main {


    public static void main(String[] args) {


        LinkedList list = new LinkedList();


        // Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);


        System.out.println("Original Linked List:");
        list.display();


        int L = 2;
        int R = 5;
        int N = 1;


        list.rotateSubList(L, R, N);


        System.out.println("\nLinked List after rotating sublist:");
        list.display();
    }
}