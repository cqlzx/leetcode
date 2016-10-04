package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n){
		List<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		helper(n - 1, n, sb, list);
		
		return list;
	}
	
	public void helper(int left, int right, StringBuffer sb, List<String> list){
		if(left == 0 && right == 0){
			list.add(sb.toString());
			return;
		}
		
		if(left > 0){
			sb.append("(");
			helper(left - 1, right, sb, list);
			sb.deleteCharAt(sb.length() - 1);
		}
			
		if(right > left){
			sb.append(")");
			helper(left, right - 1, sb, list);
			sb.deleteCharAt(sb.length() - 1);
		}
		
	}
}
