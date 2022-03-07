package token;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlusTest {
	@Test
	@DisplayName("equals 테스트")
	void equals_classType_test() {
		assertThat(new Plus().equals(new Object())).isEqualTo(false);
		assertThat(new Plus().equals(new Minus())).isEqualTo(false);
		assertThat(new Plus().equals(Token.of("-"))).isEqualTo(false);

		assertThat(new Plus().equals(new Plus())).isEqualTo(true);
		assertThat(new Plus().equals(Token.of("+"))).isEqualTo(true);
	}
}