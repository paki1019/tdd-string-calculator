package token;

public interface Operator extends Token {

    Number calculate(Number operand1, Number operand2);

    @Override
    default boolean isOperator() {
        return true;
    }

    @Override
    default boolean isOperand() {
        return false;
    }

    int getPriority();

}
