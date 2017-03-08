package math;

import java.util.*;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				int c = 0;
				switch (tokens[i]) {
					case "+": c = b + a;break;
					case "-": c = b - a;break;
					case "*": c = b * a;break;
					case "/": c = b / a;break;
				}
				stack.push(c);
			} else {
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return stack.pop();
	}
}
