/**
 * Represents a variable of a polynomial term.
 * Stores variable name, exponent and reference
 * to the next variable.
 */
public class VariableNode {


    // Variable name (x, y, z...)
    char variable;


    // Power of the variable
    int exponent;


    // Reference to next variable
    VariableNode next;


    /**
     * Creates a variable node.
     *
     * @param variable variable name
     * @param exponent exponent of the variable
     */
    public VariableNode(char variable, int exponent) {
        this.variable = variable;
        this.exponent = exponent;
        this.next = null;
    }
}