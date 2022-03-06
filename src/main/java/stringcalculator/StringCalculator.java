package stringcalculator;

import java.util.List;

import calculator.PostFixCalculator;
import converter.TokenGenerator;
import token.Token;

public class StringCalculator {
    public static int calculate(String input) {
        List<Token> inFixTokens = TokenGenerator.generate(input);

        PostFixCalculator postFixCalculator = new PostFixCalculator(inFixTokens);

        return postFixCalculator.calculate();
    }
}
