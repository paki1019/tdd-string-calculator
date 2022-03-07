package token;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TokenTest {

    @Test
    @DisplayName("정적 팩토리 메서드 테스트")
    void of() {
        assertThat(Token.of("+")).isInstanceOf(Plus.class);
        assertThat(Token.of("-")).isInstanceOf(Minus.class);
        assertThat(Token.of("*")).isInstanceOf(Multiply.class);
        assertThat(Token.of("/")).isInstanceOf(Divide.class);
        assertThat(Token.of("0")).isInstanceOf(Number.class);
    }
}