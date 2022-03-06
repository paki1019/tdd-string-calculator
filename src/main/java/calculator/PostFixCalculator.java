package calculator;

import java.util.List;
import java.util.Stack;

import converter.PostFixConverter;
import exception.CalculateFailException;
import token.Number;
import token.Operator;
import token.Token;

public class PostFixCalculator implements Calculator {

	List<Token> tokens;

	public PostFixCalculator(List<Token> inFixTokens) {
		this.tokens = PostFixConverter.convert(inFixTokens);
	}

	public int calculate() {
		Stack<Token> stack = new Stack<>();
		for (Token t : tokens) {
			if (t instanceof Operator) {
				Number operand2 = (Number)stack.pop();
				Number operand1 = (Number)stack.pop();
				stack.push(((Operator)t).calculate(operand1, operand2));
			} else {
				stack.push(t);
			}
		}

		if (stack.isEmpty()) {
			throw new CalculateFailException();
		}
		return ((Number)stack.pop()).getNumber();
	}
}
