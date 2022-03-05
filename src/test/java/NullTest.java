import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NullTest {

    @Test
    void nullEqualTest() {
        Object a = null;
        Object b = null;
        assertThat(a == b).isEqualTo(true);
        a = new Object();
        assertThat(a == b).isEqualTo(false);
        b = new Object();
        assertThat(a == b).isEqualTo(false);
    }
}
