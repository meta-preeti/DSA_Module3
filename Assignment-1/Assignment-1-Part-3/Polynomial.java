/**
 * Represents a multivariate polynomial using
 * a nested linked list.
 */
public class Polynomial {


    // Head of the polynomial
    TermNode head;


    /**
     * Inserts a new term into the polynomial.
     *
     * @param coefficient coefficient of the term
     * @return newly created term
     */
    public TermNode insertTerm(int coefficient) {


        TermNode newTerm = new TermNode(coefficient);


        if (head == null) {
            head = newTerm;
            return newTerm;
        }


        TermNode temp = head;


        while (temp.next != null) {
            temp = temp.next;
        }


        temp.next = newTerm;


        return newTerm;
    }


    /**
     * Inserts a variable into a given term.
     * @param term term in which variable is to be inserted
     * @param variable variable name
     * @param exponent exponent of the variable
     */
    public void insertVariable(TermNode term, char variable, int exponent) {


        VariableNode newVariable = new VariableNode(variable, exponent);


        if (term.variableHead == null) {
            term.variableHead = newVariable;
            return;
        }


        VariableNode temp = term.variableHead;


        while (temp.next != null) {
            temp = temp.next;
        }


        temp.next = newVariable;
    }

     /**
     * Displays the polynomial.
     */
    public void displayPolynomial() {


        TermNode term = head;
        boolean firstTerm = true;


        while (term != null) {


            if (!firstTerm) {
                if (term.coefficient >= 0) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" - ");
                }
            } else {
                if (term.coefficient < 0) {
                    System.out.print("-");
                }
                firstTerm = false;
            }


            if (Math.abs(term.coefficient) != 1 || term.variableHead == null) {
                System.out.print(Math.abs(term.coefficient));
            }


            VariableNode variable = term.variableHead;


            while (variable != null) {


                System.out.print(variable.variable);


                if (variable.exponent != 1) {
                    System.out.print("^" + variable.exponent);
                }


                variable = variable.next;
            }


            term = term.next;
        }


        System.out.println();
    }


    /**
     * Finds the degree of the polynomial.
     *
     * @return degree of the polynomial
     */
    public int findDegree() {


        int maxDegree = 0;


        TermNode term = head;


        while (term != null) {


            int currentDegree = 0;


            VariableNode variable = term.variableHead;


            while (variable != null) {
                currentDegree += variable.exponent;
                variable = variable.next;
            }


            if (currentDegree > maxDegree) {
                maxDegree = currentDegree;
            }


            term = term.next;
        }


        return maxDegree;
    }


}