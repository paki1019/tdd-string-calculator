package token;

public interface Token {
    static Token of(String s) {
        switch (s) {
            case "+":
                return new Plus();
            case "-":
                return new Minus();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            default:
                return new Operand(s);
        }
    }

    boolean isOperator();

    boolean isOperand();

}
