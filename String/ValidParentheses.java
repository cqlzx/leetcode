package string;

import java.util.*;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "(((){}))";
		boolean b = isValid(s);
		System.out.println(b);
	}

	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		
		for(char ch : s.toCharArray()){
			if(ch == '(' || ch == '[' || ch == '{'){
				stack.push(ch);
			}else if((ch == ')' || ch == ']' || ch == '}') && stack.isEmpty()){
				return false;
			}else{
				char ch_expect = map.get(ch);
				char ch_actual = stack.pop();
				if(ch_expect != ch_actual){
					return false;
				}
			}
		}
		
		if(!stack.isEmpty()){
			return false;
		}
		
		return true;
	}
}
