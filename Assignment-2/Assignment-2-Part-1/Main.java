/**
 * Driver class to test Postfix to Infix conversion.
 */
public class Main {


    public static void main(String[] args) {


        PostfixConverter converter = new PostfixConverter();


        // Test Case 1 : Assignment Example
        String postfix1 = "a b c * + d > e ! &&";
        System.out.println("Postfix : " + postfix1);
        System.out.println("Infix   : " + converter.convertToInfix(postfix1));


        System.out.println();


        // Test Case 2 : Simple Expression
        String postfix2 = "a b +";
        System.out.println("Postfix : " + postfix2);
        System.out.println("Infix   : " + converter.convertToInfix(postfix2));


        System.out.println();


        // Test Case 3 : Single Operand
        String postfix3 = "a";
        System.out.println("Postfix : " + postfix3);
        System.out.println("Infix   : " + converter.convertToInfix(postfix3));


        System.out.println();


        // Test Case 4 : Empty Expression
        String postfix4 = "";
        System.out.println("Postfix : Empty");
        System.out.println("Result  : " + converter.convertToInfix(postfix4));


        System.out.println();


        // Test Case 5 : Invalid Expression
        String postfix5 = "a +";
        System.out.println("Postfix : " + postfix5);
        System.out.println("Result  : " + converter.convertToInfix(postfix5));


        System.out.println();


        // Test Case 6 : Invalid Token
        String postfix6 = "a b @ +";
        System.out.println("Postfix : " + postfix6);
        System.out.println("Result  : " + converter.convertToInfix(postfix6));


        System.out.println();


        // Test Case 7 : Extra Operands
        String postfix7 = "a b";
        System.out.println("Postfix : " + postfix7);
        System.out.println("Result  : " + converter.convertToInfix(postfix7));
    }
}