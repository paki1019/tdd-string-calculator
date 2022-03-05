package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
        assertThat(values).hasSize(1);
        values = "1,2,3".split(",");
        assertThat(values).contains("3");
        assertThat(values).hasSize(3);
        values = "   1   2   3".split(" ");
        assertThat(values).hasSizeGreaterThan(3);
    }

    @Test
    void substring() {
        String input = "(1,2,3)";
        String result = input.substring(1);
        assertThat(result).isEqualTo("1,2,3)");
        result = input.substring(1, 3);
        assertThat(result).isEqualTo("1,");
        result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2,3");
    }

    @Test
    @DisplayName("replaceAll() 중복 공백 제거")
    void replaceAll() {
        String result = "    1  2 3".replaceAll("\\s+", " ");
        assertThat(result).isEqualTo(" 1 2 3");
        result = "    1  2            3              ".replaceAll("\\s+", " ");
        assertThat(result).isEqualTo(" 1 2 3 ");
    }

    @Test
    @DisplayName("trim()")
    void trim() {
        String result = "      1 2    4     ".trim();
        assertThat(result).isEqualTo("1 2    4");
    }
}
