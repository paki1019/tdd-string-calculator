package converter;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import token.Token;

class TokenGeneratorTest {
	@Test
	@DisplayName("문자열으로부터 토큰 생성")
	void generate() {
		List<Token> result = TokenGenerator.generate("3 + 5");
		assertThat(result).isEqualTo(List.of(Token.of("3"), Token.of("+"), Token.of("5")));
	}

	@Test
	@DisplayName("빈 문자열일 경우 빈 토큰 리스트 반환")
	void empty_string() {
		List<Token> result = TokenGenerator.generate("");
		assertThat(result).isEqualTo(List.of(Token.of("0")));
	}

	@Test
	@DisplayName("null 문자열일 경우 빈 토큰 리스트 반환")
	void null_string() {
		List<Token> result = TokenGenerator.generate("");
		assertThat(result).isEqualTo(List.of(Token.of("0")));
	}
}