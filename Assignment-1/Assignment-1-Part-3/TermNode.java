/**
 * Represents a term of a multivariate polynomial.
 * Each term stores a coefficient, a linked list of variables,
 * and a reference to the next term.
 */
public class TermNode {


    // Coefficient of the term
    int coefficient;


    // Head of the variable linked list
    VariableNode variableHead;


    // Reference to the next term
    TermNode next;


    /**
     * Creates a term node.
     *
     * @param coefficient coefficient of the term
     */
    public TermNode(int coefficient) {
        this.coefficient = coefficient;
        this.variableHead = null;
        this.next = null;
    }
}