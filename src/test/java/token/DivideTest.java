package token;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideTest {
    @Test
    @DisplayName("equals 테스트")
    void equals_classType_test() {
        assertThat(new Divide().equals(new Object())).isEqualTo(false);
        assertThat(new Divide().equals(new Multiply())).isEqualTo(false);
        assertThat(new Divide().equals(Token.of("*"))).isEqualTo(false);

        assertThat(new Divide().equals(new Divide())).isEqualTo(true);
        assertThat(new Divide().equals(Token.of("/"))).isEqualTo(true);
    }
}
