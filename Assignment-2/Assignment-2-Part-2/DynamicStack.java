/**
 * Implements a dynamic stack using an array.
 * The stack size is doubled automatically when it becomes full.
 */
public class DynamicStack implements StackInterface {

    // Array to store stack elements
    private int[] stack;

    // Index of the top element
    private int top;

    /**
     * Creates a stack of given size.
     * @param size initial capacity of the stack
     */
    public DynamicStack(int size) {
        stack = new int[size];
        top = -1;
    }


    /**
     * Doubles the capacity of the stack.
     */
    private void resize() {

        System.out.println("Stack is Full. Resizing from "
                + stack.length + " to " + (stack.length * 2));

        int[] newStack = new int[stack.length * 2];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }


    /**
     * Pushes an element onto the stack.
     * @param value element to be inserted
     */
    @Override
    public void push(int value) {

        // Resize if stack is full
        if (top == stack.length - 1) {
            resize();
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

        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = stack[top];
        top--;

        return value;
    }


    /**
     * Returns the top element.
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