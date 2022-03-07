package token;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinusTest {
	@Test
	@DisplayName("equals 테스트")
	void equals_classType_test() {
		assertThat(new Minus().equals(new Object())).isEqualTo(false);
		assertThat(new Minus().equals(new Multiply())).isEqualTo(false);
		assertThat(new Minus().equals(Token.of("*"))).isEqualTo(false);

		assertThat(new Minus().equals(new Minus())).isEqualTo(true);
		assertThat(new Minus().equals(Token.of("-"))).isEqualTo(true);
	}
}