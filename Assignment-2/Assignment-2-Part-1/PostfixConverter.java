/**
 * Converts a postfix expression into an infix expression.
 */
public class PostfixConverter {


    /**
     * Checks whether the given token is an operator.
     * @param token input token
     * @return true if operator, otherwise false
     */
    public boolean isOperator(String token) {


        return token.equals("+") || token.equals("-") ||  token.equals("*") || token.equals("/") || token.equals(">") || token.equals("<") ||
               token.equals(">=") || token.equals("<=") || token.equals("==") || token.equals("!=") || token.equals("&&") || token.equals("||") || token.equals("!");
    }


    /**
     * Checks whether the given operator is unary.
     * @param token operator
     * @return true if unary operator
     */
    public boolean isUnaryOperator(String token) {
        return token.equals("!");
    }


    /**
     * Checks whether the given token is a valid operand.
     * @param token input token
     * @return true if operand, otherwise false
     */
    public boolean isOperand(String token) {


        if (token.length() == 1) {

            char ch = token.charAt(0);

            if (Character.isLetterOrDigit(ch)) {
                return true;
            }
        }

        return false;
    }


    /**
     * Converts a postfix expression into an infix expression.
     * @param expression postfix expression
     * @return infix expression
     */
    public String convertToInfix(String expression) {


        // Edge Case 1 : Null input
        if (expression == null) {
            return "Expression is null.";
        }


        // Edge Case 2 : Empty input
        if (expression.trim().isEmpty()) {
            return "Expression is empty.";
        }


        String[] tokens = expression.split(" ");


        Stack stack = new Stack(tokens.length);


        for (String token : tokens) {

            // Operand
            if (isOperand(token)) {

                stack.push(token);
            }

            // Operator
            else if (isOperator(token)) {

                // Unary Operator
                if (isUnaryOperator(token)) {

                    if (stack.isEmpty()) {
                        return "Invalid Postfix Expression";
                    }
                    String operand = stack.pop();
                    String result = "(!" + operand + ")";
                    stack.push(result);

                }

                // Binary Operator
                else {


                    if (stack.size() < 2) {
                        return "Invalid Postfix Expression";
                    }


                    String right = stack.pop();
                    String left = stack.pop();


                    String result = "(" + left + " " + token + " " + right + ")";


                    stack.push(result);
                }
            }

            // Invalid Symbol
            else {
                return "Invalid Token : " + token;
            }
        }

        // Edge Case : Extra operands left
        if (stack.size() != 1) {
            return "Invalid Postfix Expression";
        }


        return stack.pop();
    }
}