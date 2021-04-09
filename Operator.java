
public class Operator {
    public final char operator;

    public Operator(char op){
        this.operator = op;
    }

    public double evaluate(double val1, double val2){

        return 0.0;
    }

    public int compareTo(Operator other){
        if(other.precedence() == this.precedence()){return 0;}
        if(other.precedence() > this.precedence()){return -1;}
        return 0;
    }

    public int precedence(){
        switch(this.operator){
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
        }
        return 0;
    }

    public boolean equals(Operator other){return other.operator == this.operator;}
}
