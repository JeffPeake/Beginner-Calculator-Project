import java.util.Scanner;
import java.util.Stack;

/**
 * A simple Calculator, is only able to calculate expressions with two values.
 */
public class Calculator {

    /**
     * Takes two values and an operator
     * @param val1
     * @param operator
     *      Operation to preform on the two values
     * @param val2
     * @return
     *      Returns either the answer of NaN if the operator was invalid.
     */
    private double evaluate(double val1, String operator, double val2){
        switch(operator){
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            default:
                System.out.println("Invalid operator");
                return Double.NaN;
        }

    }

    /**
     * Uses a scanner to collect two values and an operator, returning the answer
     * @param input
     *      The string of input the user entered
     * @return
     *      Returns either the answer, or NaN if it was unable to read the string
     */
    public double interpret(String input){
        Scanner interpreter = new Scanner(input);

        double val1, val2;
        String operator;
        try{
            val1 = interpreter.nextDouble();
            operator = interpreter.next();
            val2 = interpreter.nextDouble();
        }catch(Exception e){
            System.out.println("Invalid expression, please try again");
            return Double.NaN;
        }

        return evaluate(val1, operator, val2);
    }

    public double alternateInterpret(String input){



        return 0.0;
    }

    /**
     * Empty constructor
     */
    public Calculator(){}
}
