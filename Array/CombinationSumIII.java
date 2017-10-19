package array;

import java.util.*;

public class CombinationSumIII {

	public static void main(String[] args) {
		List<List<Integer>> res = new CombinationSumIII().combinationSum3(5, 20);
		for (List<Integer> one : res) {
			System.out.println(one.toString());
		}
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (k > 9 || n > 45) return res;
		helper(k, 1, n, res, new ArrayList<>());
		return res;
	}
	private void helper(int k, int start, int remain, List<List<Integer>> res, List<Integer> one) {
		if (k == 0) {
			if (remain == 0) {
				res.add(new ArrayList<Integer>(one));
			}
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			if (remain >= i) {
				one.add(i);
				helper(k - 1, i + 1, remain - i, res, one);
				one.remove(one.size() - 1);
			}
		}
	}
}
