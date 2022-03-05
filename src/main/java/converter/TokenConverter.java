package converter;

import token.Token;

import java.util.List;
import java.util.stream.Collectors;

public class TokenConverter {
    public static List<Token> convert(List<String> strings) {
        return strings.stream().map(Token::of).collect(Collectors.toList());
    }

}
