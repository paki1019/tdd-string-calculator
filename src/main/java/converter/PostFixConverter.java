package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import exception.ConvertFailException;
import token.Token;

public class PostFixConverter {
    public static List<Token> convert(List<Token> tokens) {
        List<Token> result = new ArrayList<>();
        Stack<Token> stack = new Stack();
        Token prevToken = null;

        for (Token s : tokens) {
            if (s.isOperator()) {
                if (prevToken != null && prevToken.isOperator()) {
                    throw new ConvertFailException();
                }
                if (!stack.isEmpty()) {
                    result.add(stack.pop());
                }
                stack.push(s);
            } else {
                if (prevToken != null && prevToken.isOperand()) {
                    throw new ConvertFailException();
                }
                result.add(s);
            }
            prevToken = s;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
