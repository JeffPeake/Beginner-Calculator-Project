import java.util.Stack;

/**
 * Evaluates Postfix mathematical expressions
 */
public class PostfixCalculator{

    /**
     * Takes a Postfix mathematical string and returns a double value result of the expression.
     * @param input
     * @return
     */
    public static double evaluate(String input){
        Stack<Double> valStack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            char token = input.charAt(i);

            switch(token){
                case '+':
                    valStack.push(valStack.pop() + valStack.pop());
                    break;
                case '-':
                    valStack.push((-valStack.pop()) + valStack.pop());
                    break;
                case '*':
                    valStack.push(valStack.pop() * valStack.pop());
                    break;
                case '/':
                    double divisor = valStack.pop();
                    valStack.push(valStack.pop() / divisor);
                    break;
                case '^':
                    double power = valStack.pop();
                    valStack.push(Math.pow(valStack.pop(), power));
                    break;
                case ' ':
                    continue;
                default: // token is a value
                    valStack.push((double)Character.getNumericValue(token));
            }
        }

        return valStack.pop();
    }

}
