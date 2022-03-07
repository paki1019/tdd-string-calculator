package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import exception.ConvertFailException;
import token.Operator;
import token.Token;

public class PostFixConverter {
    public static List<Token> convert(List<Token> tokens) {
        List<Token> result = new ArrayList<>();
        Stack<Operator> stack = new Stack();
        Token prevToken = null;

        for (Token t : tokens) {
            if (t instanceof Operator) {
                if (prevToken != null && prevToken.isOperator()) {
                    throw new ConvertFailException();
                }
                if (!stack.isEmpty() && stack.peek().getPriority() >= ((Operator)t).getPriority()) {
                    result.add(stack.pop());
                }
                stack.push((Operator)t);
            } else {
                if (prevToken != null && prevToken.isOperand()) {
                    throw new ConvertFailException();
                }
                result.add(t);
            }
            prevToken = t;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
