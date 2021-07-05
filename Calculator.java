import java.util.Scanner;

/**
 * Simple calculator, uses shunting yard algorithm and postfix calculator to evaluate simple mathematical expressions
 */
public class Calculator{

    /**
     * Continues to take user input, attempting to evaluate the expression entered by the user.
     * @param args
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(true){
            try{
                String exp = s.nextLine(); // infix expression
                String rpnExp = ShuntingYard.InfixToPostfix(exp); // Reverse Polish notation of the entered expression
                System.out.println(PostfixCalculator.evaluate(rpnExp));
            }catch(IllegalArgumentException e){
                System.out.println("Invalid infix expression: " + e.getMessage());
            }

        }
    }
}
