/**
 * Implements a fixed-size stack using an array.
 */
public class FixedStack implements StackInterface {


    // Array to store stack elements
    private int[] stack;


    // Index of the top element
    private int top;


    /**
     * Creates a stack of given size.
     * @param size maximum capacity of the stack
     */
    public FixedStack(int size) {
        stack = new int[size];
        top = -1;
    }


    /**
     * Pushes an element onto the stack.
     * @param value element to be inserted
     */
    @Override
    public void push(int value) {
        // Edge Case : Stack Overflow
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        stack[top] = value;
        System.out.println(value + " pushed into stack");
    }


    /**
     * Removes and returns the top element.
     * @return removed element
     */
    @Override
    public int pop() {

        // Edge Case : Stack Underflow
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = stack[top];
        top--;
        return value;
    }


    /**
     * Returns the top element without removing it.
     * @return top element
     */
    @Override
    public int peek() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return stack[top];
    }


    /**
     * Checks whether the stack is empty.
     * @return true if stack is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}