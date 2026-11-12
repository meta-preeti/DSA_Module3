/**
 * Defines the basic operations of a Stack.
 */
public interface StackInterface {


    /**
     * Pushes an element onto the stack.
     * @param value element to be inserted
     */
    void push(int value);


    /**
     * Removes and returns the top element.
     * @return top element of the stack
     */
    int pop();


    /**
     * Returns the top element without removing it
     * @return top element
     */
    int peek();


    /**
     * Checks whether the stack is empty.
     * @return true if stack is empty, otherwise false
     */
    boolean isEmpty();

}