package converter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.ConvertFailException;
import token.Token;

class PostFixConverterTest {

    @Test
    @DisplayName("정적 메서드 호출 성공")
    void static_method_success() {
        assertDoesNotThrow(() -> {
            PostFixConverter.convert(List.of(Token.of("1"), Token.of("+"), Token.of("3")));
        });
    }

    @Test
    @DisplayName("빈 리스트 입력 빈 리스트 반환")
    void convert_empty() {
        List<Token> result = PostFixConverter.convert(List.of());
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("숫자 토큰 연속 입력, 예외 반환")
    void input_sequence_number_token() {
        assertThrows(ConvertFailException.class, () -> PostFixConverter.convert(List.of(Token.of("1"), Token.of("2"))));
    }

    @Test
    @DisplayName("연산자 토큰 연속 입력, 예외 반환")
    void input_sequence_operator_token() {
        assertThrows(ConvertFailException.class, () -> PostFixConverter.convert(List.of(Token.of("1"), Token.of("2"))));
    }

    @Test
    @DisplayName("숫자 토큰 하나 입력 숫자 토큰 하나 반환")
    void input_one_number_token() {
        List<Token> result = PostFixConverter.convert(List.of(Token.of("1")));
        assertThat(result).isEqualTo(List.of(Token.of("1")));

        result = PostFixConverter.convert(List.of(Token.of("3")));
        assertThat(result).isEqualTo(List.of(Token.of("3")));
    }

    @Test
    @DisplayName("숫자 + 숫자 입력, 숫자 숫자 + 반환")
    void input_number_plus_number() {
        List<Token> result = PostFixConverter.convert(List.of(Token.of("1"), Token.of("+"), Token.of("2")));
        assertThat(result).isEqualTo(List.of(Token.of("1"), Token.of("2"), Token.of("+")));

        result = PostFixConverter.convert(List.of(Token.of("3"), Token.of("+"), Token.of("4")));
        assertThat(result).isEqualTo(List.of(Token.of("3"), Token.of("4"), Token.of("+")));
    }

    @Test
    @DisplayName("숫자 + 숫자 - 숫자")
    void number_plus_number_minus_number() {
        List<Token> result = PostFixConverter.convert(List.of(Token.of("1"), Token.of("+"), Token.of("2"), Token.of("-"), Token.of("-2")));
        assertThat(result).isEqualTo(List.of(Token.of("1"), Token.of("2"), Token.of("+"), Token.of("-2"), Token.of("-")));

        result = PostFixConverter.convert(List.of(Token.of("3"), Token.of("+"), Token.of("4"), Token.of("-"), Token.of("-2")));
        assertThat(result).isEqualTo(List.of(Token.of("3"), Token.of("4"), Token.of("+"), Token.of("-2"), Token.of("-")));

        result = PostFixConverter.convert(List.of(Token.of("3"), Token.of("-"), Token.of("1"), Token.of("+"), Token.of("6")));
        assertThat(result).isEqualTo(List.of(Token.of("3"), Token.of("1"), Token.of("-"), Token.of("6"), Token.of("+")));
    }

    @Test
    @DisplayName("숫자 * 숫자 + 숫자")
    void number_multiply_number_plus_number() {
        List<Token> result = PostFixConverter.convert(List.of(Token.of("1"), Token.of("*"), Token.of("2"), Token.of("+"), Token.of("-2")));
        assertThat(result).isEqualTo(List.of(Token.of("1"), Token.of("2"), Token.of("*"), Token.of("-2"), Token.of("+")));

        result = PostFixConverter.convert(List.of(Token.of("3"), Token.of("*"), Token.of("4"), Token.of("+"), Token.of("-2")));
        assertThat(result).isEqualTo(List.of(Token.of("3"), Token.of("4"), Token.of("*"), Token.of("-2"), Token.of("+")));
    }

    @Test
    @DisplayName("숫자 + 숫자 * 숫자")
    void number_plus_number_multiply_number() {
        List<Token> result = PostFixConverter.convert(List.of(Token.of("1"), Token.of("+"), Token.of("2"), Token.of("*"), Token.of("-2")));
        assertThat(result).isEqualTo(List.of(Token.of("1"), Token.of("2"), Token.of("-2"), Token.of("*"), Token.of("+")));

        result = PostFixConverter.convert(List.of(Token.of("3"), Token.of("+"), Token.of("4"), Token.of("*"), Token.of("-2")));
        assertThat(result).isEqualTo(List.of(Token.of("3"), Token.of("4"), Token.of("-2"), Token.of("*"), Token.of("+")));
    }

}