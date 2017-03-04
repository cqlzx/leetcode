package array;

import java.util.*;

public class Combinations {

	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		for(List<Integer> one : res){
			System.out.println(one.toString());
		}
	}

	public static List<List<Integer>> combine(int n, int k){
		List<Integer> one = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		helper(0, n, k, one, res);
		return res;
	}
	
	public static void helper(int start, int n, int k, List<Integer> one, List<List<Integer>> res){
		if(k == 0){
			List<Integer> tmp = new ArrayList<>(one);
			res.add(tmp);
			return;
		}
		
		for(int i = start; i < n - k + 1; i++){
			one.add(i + 1);
			helper(i + 1, n, k - 1, one, res);
			one.remove(one.size() - 1);
		}
	}
}
