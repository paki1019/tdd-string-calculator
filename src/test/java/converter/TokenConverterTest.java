package converter;

import org.junit.jupiter.api.Test;
import token.Token;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TokenConverterTest {

    @Test
    void convert() {
        List<Token> result = TokenConverter.convert(List.of("3", "+", "5"));
        assertThat(result).isEqualTo(List.of(Token.of("3"), Token.of("+"), Token.of("5")));
    }
}