package math;

import java.util.*;

public class HappyNumber {
	public static void main(String args[]){
		boolean res = isHappy(21);
		System.out.println(res);
	}
	public static boolean isHappy(int n){
		Set<Integer> set = new HashSet<Integer>();
		while(n != 1){
			set.add(n);
			int sum = 0;
			while(n != 0){
				int digit = n % 10;
				sum += digit * digit;
				n /= 10;
			}
			n = sum;
			if(set.contains(n)){
				return false;
			}
		}
		
		return true;
	}
}
