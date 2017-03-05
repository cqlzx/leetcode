package string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = {30304, 30, 34, 5, 9};
//		int[] nums2 = {121, 12};
		String res = largestNumber(nums);
		System.out.println(res);
	}
	
	//Solution 1, concat two string to compare
	public static String largestNumber(int[] nums) {
		String[] numbers = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numbers[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(numbers, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str2.compareTo(str1);
			}
		});
		
		if(numbers[0].charAt(0) == '0') return "0";
		
		StringBuilder sb = new StringBuilder();
		for (String number : numbers) {
			sb.append(number);
		}
		
		return sb.toString();
	}
	
	
	//Solution 2, different way to compare
	public static String largestNumber2(int[] nums) {
		String[] numbers = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numbers[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(numbers, new Comparator<String>() {
			public int compare(String s1, String s2) {
				long len = s1.length() * s2.length();
				for (int i = 0; i < len; i++) {
					char c1 = i < s1.length() ? s1.charAt(i) : s1.charAt(i % s1.length());
					char c2 = i < s2.length() ? s2.charAt(i) : s2.charAt(i % s2.length());
					if (c1 > c2) return -1;
					else if(c1 < c2) return 1;
				}
				
				return 0;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String number : numbers) {
			sb.append(number);
		}
		
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		
		return sb.toString();
	}
}
