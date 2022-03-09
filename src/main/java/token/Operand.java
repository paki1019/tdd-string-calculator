package token;

import java.util.Objects;

public class Operand implements Token {
    private int number;

    public Operand(String s) {
        this.number = Integer.parseInt(s);
    }

    public Operand(int number) {
        this.number = number;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public boolean isOperand() {
        return true;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand number = (Operand) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
