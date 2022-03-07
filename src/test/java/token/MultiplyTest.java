package token;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MultiplyTest {

	@Test
	@DisplayName("equals 테스트")
	void equals_classType_test() {
		assertThat(new Multiply().equals(new Object())).isEqualTo(false);
		assertThat(new Multiply().equals(new Minus())).isEqualTo(false);
		assertThat(new Multiply().equals(Token.of("-"))).isEqualTo(false);

		assertThat(new Multiply().equals(new Multiply())).isEqualTo(true);
		assertThat(new Multiply().equals(Token.of("*"))).isEqualTo(true);
	}
}