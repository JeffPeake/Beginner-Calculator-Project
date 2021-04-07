import java.util.Scanner;

/**
 * A simple calculator, accepts user input until exited
 * @author Jeff
 */
public class CalculatorProgram {

    /**
     * Initialises a Calculator and Scanner, then continues to calculate given expressions until
     * 'exit' is read.
     * @param args
     */
    public static void main(String[] args){
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        System.out.println("**Calculator loaded, enter 'exit' to quit program**\nEnter equation:");
        String expression = scan.nextLine();

        while(!expression.equals("exit")){
            double answer = calc.interpret(expression);
            if(!Double.isNaN(answer)){
                System.out.printf("%.2f\n", answer);
            }
            expression = scan.nextLine();
        }
        System.out.println("**Quitting calculator**");
        scan.close();
    }
}
