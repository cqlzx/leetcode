package string;

import java.util.*;

public class PalindromePartitioning {

	public static void main(String[] args) {
		List<List<String>> res = partition("aab");
		for (List<String> one : res) {
			System.out.println(one.toString());
		}
//		int a = 10;
//		System.out.println("a 非的结果是：" + (~a));
	}
	
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> one = new ArrayList<>();
		helper(s, res, one);
		return res;
	}
	
	public static void helper(String s, List<List<String>> res, List<String> one) {
		if (s.length() == 0) {
			res.add(new ArrayList<>(one));
			return;
		}
		
		for (int l = 1; l <= s.length(); l++) {
			String str1 = s.substring(0, l);
			if (isPalindrome(str1)) {
				one.add(str1);
				String str2 = s.substring(l, s.length());
				helper(str2, res, one);
				one.remove(one.size() - 1);
			}
		}
	}
	
	public static boolean isPalindrome(String s) {
		char[] s_array = s.toCharArray();
		int i = 0, j = s_array.length - 1;
		while (i < j) {
			if (s_array[i] != s_array[j]) return false;
			i++;
			j--;
		}
		return true;
	}
}
