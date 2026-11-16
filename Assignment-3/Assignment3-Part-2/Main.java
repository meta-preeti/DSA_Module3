/**
 * Driver class to test the Priority Queue.
 */
public class Main {


    public static void main(String[] args) {

        PriorityQueueOperation queue = new PriorityQueueOperation();
        System.out.println("========== INSERT ==========\n");

        queue.insert("Laptop", 5);
        queue.insert("Mouse", 2);
        queue.insert("Keyboard", 4);
        queue.insert("Monitor", 7);
        queue.insert("CPU", 10);
        queue.insert("Speaker", 4);


        System.out.println("\n========== SIZE ==========\n");
        System.out.println("Queue Size : " + queue.size());


        System.out.println("\n========== PEEK ==========\n");
        System.out.println("Highest Priority Item : " + queue.peek());


        System.out.println("\n========== REMOVE TOP ==========\n");
        System.out.println("Removed Item : " + queue.removeTop());


        System.out.println("\nHighest Priority Item : " + queue.peek());


        System.out.println("\n========== CHANGE PRIORITY ==========\n");
        queue.changePriority("Mouse", 8);


        System.out.println("Highest Priority Item : " + queue.peek());

        System.out.println("\n========== EDGE CASES ==========\n");


        queue.insert("", 5);


        queue.insert("   ", 2);


        queue.insert(null, 3);


        queue.changePriority("", 5);


        queue.changePriority(null, 10);


        queue.changePriority("Mobile", 7);


        System.out.println("\n========== REMOVE ALL ==========\n");


        while (!queue.isEmpty()) {
            System.out.println(queue.removeTop());
        }


        System.out.println("\n========== EMPTY QUEUE ==========\n");


        queue.removeTop();

        System.out.println(queue.peek());


        System.out.println("Queue Size : " + queue.size());
        System.out.println("Is Queue Empty : " + queue.isEmpty());
    }
}