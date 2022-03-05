package token;

public interface Token {
    static Token of(String s) {
        if (s.equals("+")) {
            return new Plus();
        } else if (s.equals("-")) {
            return new Minus();
        } else {
            return new Number(s);
        }
    }

    boolean isOperator();

    boolean isOperand();
}
