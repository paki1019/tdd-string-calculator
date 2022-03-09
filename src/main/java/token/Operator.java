package token;

public interface Operator extends Token {

    Operand calculate(Operand operand1, Operand operand2);

    @Override
    default boolean isOperator() {
        return true;
    }

    @Override
    default boolean isOperand() {
        return false;
    }

    int getPriority();

    boolean equals(Object obj);
}