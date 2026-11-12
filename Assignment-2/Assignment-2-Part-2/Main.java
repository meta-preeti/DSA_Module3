/**
 * Driver class to test Fixed Stack and Dynamic Stack.
 */
public class Main {


    public static void main(String[] args) {

        System.out.println(" Fixed Size Stack : ");

        FixedStack fixedStack = new FixedStack(3);

        fixedStack.push(10);
        fixedStack.push(20);
        fixedStack.push(30);
        fixedStack.push(40);   // Stack Overflow

        System.out.println("Top Element : " + fixedStack.peek());
        System.out.println("Popped Element : " + fixedStack.pop());
        System.out.println("Popped Element : " + fixedStack.pop());
        System.out.println("Popped Element : " + fixedStack.pop());
        System.out.println("Popped Element : " + fixedStack.pop()); // Underflow


        System.out.println("\n Dynamic Stack : ");
        DynamicStack dynamicStack = new DynamicStack(3);

        dynamicStack.push(10);
        dynamicStack.push(20);
        dynamicStack.push(30);
        dynamicStack.push(40);   // Resize to 6
        dynamicStack.push(50);
        dynamicStack.push(60);
        dynamicStack.push(70);   // Resize to 12


        System.out.println("Top Element : " + dynamicStack.peek());
        System.out.println("Popped Element : " + dynamicStack.pop());
        System.out.println("Popped Element : " + dynamicStack.pop());
        System.out.println("Popped Element : " + dynamicStack.pop());
        System.out.println("Popped Element : " + dynamicStack.pop());
        System.out.println("Popped Element : " + dynamicStack.pop());
        System.out.println("Popped Element : " + dynamicStack.pop());
        System.out.println("Popped Element : " + dynamicStack.pop()); // Underflow
    }
}