package token;

public class Plus implements Operator {

    @Override
    public Operand calculate(Operand operand1, Operand operand2) {
        return new Operand(operand1.getNumber() + operand2.getNumber());
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Plus;
    }
}
