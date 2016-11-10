package array;

import java.util.*;

public class PlusOne {

	public static void main(String[] args) {
		int[] org = {9};
		int[] ans = plusOne(org);
		for(int i : ans){
			System.out.println(i);
		}
	}
	
	public static int[] plusOne(int[] digits){
		int carry = 1;
		int i = digits.length - 1;
		List<Integer> res = new ArrayList<>();
		
		while(carry > 0){
			if(i < 0){
				res.add(0, 1);
				break;
			}
			
			int tmp = digits[i] + carry;
			res.add(0, tmp % 10);
			carry = tmp / 10;
			i--;
		}
			
		while(i >= 0){
			res.add(0, digits[i]);
			i--;
			
		}
		
		int[] ans = new int[res.size()];
		for(int j = 0; j < res.size(); j++){
			ans[j] = res.get(j);
		}
		
		return ans;
	}
}
