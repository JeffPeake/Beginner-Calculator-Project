/**
 * Expression
 */
public class Expression{
    private double leftVal;
    private double rightVal;
    private Expression leftExpr;
    private Expression rightExpr;

    public Expression(double left, double right){
        this.leftVal = left;
        this.rightVal = right;
    }

    public Expression(Expression left, Expression right){
        this.leftExpr = left;
        this.rightExpr = right;
    }

    public double evaluate(char operator){

        return 0.0;
    }
}