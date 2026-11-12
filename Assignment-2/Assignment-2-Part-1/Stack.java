/**
 * Implements a stack using an array.
 * This stack stores String elements.
 */
public class Stack {


    // Array to store stack elements
    private String[] stack;


    // Index of the top element
    private int top;


    /**
     * Creates a stack of given size.
     * @param size maximum size of the stack
     */
    public Stack(int size) {
        stack = new String[size];
        top = -1;
    }


    /**
     * Pushes an element onto the stack.
     * @param value element to be inserted
     */
    public void push(String value) {
        top++;
        stack[top] = value;
    }


    /**
     * Removes and returns the top element.
     * @return top element of the stack
     */
    public String pop() {
        String value = stack[top];
        top--;
        return value;
    }


    /**
     * Returns the top element without removing it.
     * @return top element
     */
    public String peek() {
        return stack[top];
    }


    /**
     * Checks whether the stack is empty.
     * @return true if stack is empty, otherwise false
     */
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * Returns the current number of elements in the stack.
     * @return size of the stack
     */
    public int size() {
        return top + 1;
    }
}