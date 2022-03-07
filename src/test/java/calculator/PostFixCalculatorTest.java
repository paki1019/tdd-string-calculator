package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import token.Token;

class PostFixCalculatorTest {

	@Test
	@DisplayName("양수 하나 입력")
	void input_only_one_positive_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(List.of(Token.of("1")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(1);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("3")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("음수 하나 입력")
	void input_only_one_negative_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(List.of(Token.of("-1")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(-1);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("-3")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(-3);
	}

	@Test
	@DisplayName("숫자 + 숫자")
	void number_plus_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(List.of(Token.of("3"), Token.of("+"), Token.of("1")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(4);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("3"), Token.of("+"), Token.of("-1")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(2);
	}

	@Test
	@DisplayName("숫자 - 숫자")
	void number_minus_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(List.of(Token.of("3"), Token.of("-"), Token.of("1")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(2);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("3"), Token.of("-"), Token.of("-1")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(4);
	}

	@Test
	@DisplayName("숫자 - 숫자 + 숫자")
	void number_minus_number_plus_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(
			List.of(Token.of("3"), Token.of("-"), Token.of("1"), Token.of("+"), Token.of("6")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(8);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("3"), Token.of("-"), Token.of("-1"), Token.of("+"), Token.of("7")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(11);
	}

	@Test
	@DisplayName("숫자 * 숫자")
	void number_multiply_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(List.of(Token.of("3"), Token.of("*"), Token.of("4")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(12);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("2"), Token.of("*"), Token.of("-7")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(-14);
	}

	@Test
	@DisplayName("숫자 * 숫자 + 숫자")
	void number_multiply_number_plus_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(
			List.of(Token.of("3"), Token.of("*"), Token.of("4"), Token.of("+"), Token.of("2")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(14);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("2"), Token.of("*"), Token.of("-7"), Token.of("+"), Token.of("4")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(-10);
	}

	@Test
	@DisplayName("숫자 + 숫자 * 숫자")
	void number_plus_number_multiply_number() {
		PostFixCalculator postFixCalculator = new PostFixCalculator(
			List.of(Token.of("3"), Token.of("+"), Token.of("4"), Token.of("*"), Token.of("2")));
		int result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(11);
		postFixCalculator = new PostFixCalculator(List.of(Token.of("2"), Token.of("+"), Token.of("-7"), Token.of("*"), Token.of("4")));
		result = postFixCalculator.calculate();
		assertThat(result).isEqualTo(-26);
	}
}