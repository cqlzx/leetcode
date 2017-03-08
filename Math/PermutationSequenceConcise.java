package math;

import java.util.*;

public class PermutationSequenceConcise {
	public static void main(String args[]){
		String s = getPermutation(4, 7);
		System.out.println(s);
	}
	
	public static String getPermutation(int n, int k){
		List<Integer> sequence = new ArrayList<>();
		for(int i = 1; i <= n; i++){
			sequence.add(i);
		}
		
		int factorial = 1;
		for(int i = n - 1; i > 0; i--){
			factorial *= i;
		}
		
		StringBuilder sb = new StringBuilder();
		k = k - 1;
		for(int j = n - 1; j >= 0; j--){
			int index = 0;
			if(k != 0){
				index = k / factorial;	
			}
			
			sb.append(sequence.get(index));
			sequence.remove(index);
			k %= factorial;
			if(j != 0){
				factorial /= j;	
			}
		}
		
		return sb.toString();
	}
}
