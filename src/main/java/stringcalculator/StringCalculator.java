package stringcalculator;

import converter.PostFixConverter;
import converter.TokenConverter;
import exception.ZeroResultException;
import token.Number;
import token.Operator;
import token.Token;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringCalculator {
    public static int calculate(String input) {
        try {
            validateZeroResult(input);
            input = input.replaceAll("\\s+", " ").trim();
            List<Token> infixTokens = TokenConverter.convert(Arrays.asList(input.split(" ")));
            List<Token> postfixTokens = PostFixConverter.convert(infixTokens);

            return calculatePostFix(postfixTokens);
        } catch (ZeroResultException e) {
            return 0;
        }
    }

    private static int calculatePostFix(List<Token> postfixTokens) {
        Stack<Token> stack = new Stack<>();
        for (Token s : postfixTokens) {
            if (s instanceof Operator) {
                Number operand2 = (Number) stack.pop();
                Number operand1 = (Number) stack.pop();
                stack.push(((Operator)s).calculate(operand1, operand2));
            } else {
                stack.push(s);
            }
        }

        if (!stack.isEmpty()) {
            return ((Number) stack.pop()).getNumber();
        }

        return 0;
    }

    private static void validateZeroResult(String input) {
        if (input == null) {
            throw new ZeroResultException();
        }

        if (input.isBlank()) {
            throw new ZeroResultException();
        }
    }
}
