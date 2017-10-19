package string;

import java.util.*;

public class BasicCalculatorII {

	public static void main(String[] args) {
		int res = new BasicCalculatorII().calculate("876-142-978*2/8+4/2*2+40*2+282/2-137+855");
		System.out.println(res);
	}
	
	//Solution 1, using stack.
	public int calculate(String s) {
		s = s.trim();
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == ' ') continue;
			if (cur >= '0' && cur <= '9') num = num * 10 + cur - '0';
			
			if (cur < '0' || cur > '9' || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else {
					stack.push(stack.pop() / num);
				}
				sign = cur;
				num = 0;
			}
		}
		
		int res = 0;
		for (int i : stack) {
			res += i;
		}
		
		return res;
	}
	
	//Solution 2, consider every case. Not good and slow.
	public int calculate2(String s) {
        StringBuilder sb = new StringBuilder();
        String num1 = "", num2 = "", operator = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') continue;
            if (arr[i] >= '0' && arr[i] <= '9') {
                if (operator.length() == 0) {
                    num1 += arr[i];
                } else {
                    num2 += arr[i];
                }
            } else {
                if (operator.length() == 0) {
                    operator += arr[i];
                } else {
                    if ((operator.equals("+") || operator.equals("-")) && (arr[i] == '*' || arr[i] == '/')) {
                        sb.append(num1 + operator);
                        num1 = num2;
                        operator = arr[i] + "";
                    } else if ((operator.equals("*") || operator.equals("/")) && (arr[i] == '*' || arr[i] == '/')){
                    	int tmp = helper(num1, num2, operator);
                        num1 = tmp + "";
                        operator = arr[i] + "";
                    } else if ((operator.equals("*") || operator.equals("/")) && (arr[i] == '+' || arr[i] == '-')){
                    	int tmp = helper(num1, num2, operator);
                    	sb.append(tmp + "" + arr[i]);
                    	num1 = "";
                    	operator = "";
                    } else {
                    	sb.append(num1 + operator + num2 + arr[i]);
                    	num1 = "";
                    	operator = "";
                    }
                    num2 = "";
                }
            }
        }
        
        if (operator.length() != 0 && (operator.equals("*") || operator.equals("/"))) {
        	sb.append(helper(num1, num2, operator) + "");
        } else {
        	sb.append(num1 + operator + num2);
        }
        
        
        operator = "";
        num1 = "0";
        num2 = "";
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                if (operator.length() == 0) {
                    num1 += sb.charAt(i);
                } else {
                    num2 += sb.charAt(i);
                }
            } else {
                if (operator.length() == 0) {
                    operator += sb.charAt(i);
                } else {
                    int tmp = helper(num1, num2, operator);
                    num1 = tmp + "";
                    operator = sb.charAt(i) + "";
                    num2 = "";
                }
            }
        }
        
        if (operator.length() == 0) {
        	return Integer.parseInt(num1);
        } else {
        	return helper(num1, num2, operator);	
        }     
	}
    private int helper(String num1, String num2, String operator) {
        switch (operator) {
            case "+" : return Integer.parseInt(num1) + Integer.parseInt(num2);
            case "-" : return Integer.parseInt(num1) - Integer.parseInt(num2);
            case "*" : return Integer.parseInt(num1) * Integer.parseInt(num2);
            case "/" : return Integer.parseInt(num1) / Integer.parseInt(num2);
        }
        return 0;
    }
}
