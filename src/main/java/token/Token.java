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
            default:
                return new Number(s);
        }
    }

    boolean isOperator();

    boolean isOperand();

}
