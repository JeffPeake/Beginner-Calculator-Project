import java.util.Stack;

/**
 * Implements Dijkstra's Shunting-yard algorithm, converting from prefix notation to postfix (Reverse polish notation).
 * Supports the operators that are listed in getPrecedence() and the expressions listed in InfixToPostfix().
 */
public class ShuntingYard{

    /**
     * Returns integer to indicate precedence of a given operator.
     * @param c
     *          The character, valid characters are +,-,*,/,^. Method also handles brackets
     * @return
     */
    private static int getPrecedence(char c){
        if(c == '+' || c == '-'){return 1;}
        if(c == '*' || c == '/'){return 2;}
        if(c == '^'){return 3;}
        if(c == '(' || c == ')'){return -1;}

        throw new IllegalArgumentException("Invalid operator: " + c);
    }

    /**
     * Converts a string representing a mathematical expression from Infix to Postfix notation (Reverse Polish Notation)
     * - Supports whitespaces in the text and bracketed expressions
     * - Does not support functions or variables (eg. sin, x)
     * @param input
     *              A Infix notation mathematical expression string
     * @return
     *              A Postfix notation mathematical expression String
     */
    public static String InfixToPostfix(String input){
        String output = "";
        Stack<Character> opStack = new Stack<>(); // stores operators until they need to be added to output

        // work through each character in input string, moving values to the output and operators to the opStack
        for(int i = 0; i < input.length(); i++){
            char token = input.charAt(i);
            if(Character.isWhitespace(token)){continue;}

            if(Character.isDigit(token)){
                output += token;
            }else if(token == '('){
                opStack.push(token);
            }else if(token == ')'){
                // move the operators in the stack to the output until a left bracket is found, or stack is empty:
                while(!opStack.isEmpty() && opStack.peek() != '('){
                    output += opStack.pop();
                }
                // if stack is emptied before finding a left bracket, then there is a bracket mismatch:
                if(opStack.isEmpty()){throw new IllegalArgumentException("Bracket mismatch in infix expression: missing '('");}
                //else{output += opStack.pop();}
                else{opStack.pop();}
            }else{
                // token must be an operator (this must be changed for support of functions)
                while(!opStack.isEmpty() && getPrecedence(token) <= getPrecedence(opStack.peek())){ // precedence of current token is less than or equal to next on opStack
                    output += opStack.pop();
                }
                opStack.push(token);
            }


        }

        // add all remaining operators in opStack to the output
        while(!opStack.isEmpty()){
            if(opStack.peek() == '('){
                throw new IllegalArgumentException("Bracket mismatch in infix expression: unexpected '('");
            }
            output += opStack.pop();
        }

        return output;
    }

}
