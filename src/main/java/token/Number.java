package token;

import java.util.Objects;

public class Number implements Token {
    private int number;

    public Number(String s) {
        this.number = Integer.parseInt(s);
    }

    public Number(int number) {
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
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
