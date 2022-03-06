package converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import token.Token;

public class TokenGenerator {
    public static List<Token> generate(String input) {
        if (input == null) {
            return List.of(Token.of("0"));
        }
        if (input.isBlank()) {
            return List.of(Token.of("0"));
        }

        return Arrays.stream(input.replaceAll("\\s+", " ").trim().split(" "))
            .map(Token::of)
            .collect(Collectors.toList());
    }
}
