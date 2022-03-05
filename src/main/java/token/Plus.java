package token;

public class Plus implements Operator {

    @Override
    public Number calculate(Number operand1, Number operand2) {
        return new Number(operand1.getNumber() + operand2.getNumber());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}