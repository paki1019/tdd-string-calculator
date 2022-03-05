package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("정적 메서드 호출 성공")
    void static_method_success() {
        assertDoesNotThrow(() -> {
            StringCalculator.calculate("123");
        });
    }

    @Test
    @DisplayName("입력 null일 경우 0 반환")
    void input_null() {
        int result = StringCalculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력 공백일 경우 0 반환")
    void input_empty() {
        int result = StringCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("양수 하나 입력")
    void input_only_one_positive_number() {
        int result = StringCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
        result = StringCalculator.calculate("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("음수 하나 입력")
    void input_only_one_negative_number() {
        int result = StringCalculator.calculate("-1");
        assertThat(result).isEqualTo(-1);
        result = StringCalculator.calculate("-3");
        assertThat(result).isEqualTo(-3);
    }

    @Test
    @DisplayName("숫자 + 숫자")
    void number_plus_number() {
        int result = StringCalculator.calculate("3 + 1   ");
        assertThat(result).isEqualTo(4);
        result = StringCalculator.calculate("    3 + -1");
        assertThat(result).isEqualTo(2);
        result = StringCalculator.calculate("-3 +   -1");
        assertThat(result).isEqualTo(-4);
        result = StringCalculator.calculate("-3 + 1");
        assertThat(result).isEqualTo(-2);
    }


    @Test
    @DisplayName("숫자 - 숫자")
    void number_minus_number() {
        int result = StringCalculator.calculate("3 - 1");
        assertThat(result).isEqualTo(2);
        result = StringCalculator.calculate("3 - -1");
        assertThat(result).isEqualTo(4);
        result = StringCalculator.calculate("-3   - -1");
        assertThat(result).isEqualTo(-2);
        result = StringCalculator.calculate("-3 -       1");
        assertThat(result).isEqualTo(-4);
    }

    @Test
    @DisplayName("숫자 - 숫자 + 숫자")
    void number_multiple_operator() {
        int result = StringCalculator.calculate("3 - 1 + 6");
        assertThat(result).isEqualTo(8);
        result = StringCalculator.calculate("3 - -1 + 7");
        assertThat(result).isEqualTo(11);
        result = StringCalculator.calculate("-3   - -1 + 2");
        assertThat(result).isEqualTo(0);
        result = StringCalculator.calculate("-3 -       1 + 5");
        assertThat(result).isEqualTo(1);
    }
}