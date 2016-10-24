package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void main(String args[]){
		int[] candidate = new int[]{1, 1, 2, 5, 6, 7, 10};
		List<List<Integer>> res = combinationSum2(candidate, 8);
		for(List<Integer> list : res){
			System.out.println(list.toString());
		}
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidate, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		if(candidate.length == 0){
			return res;
		}
		Arrays.sort(candidate);
		findSum(candidate, 0, target, tmp, res);
		return res;
	}
	
	public static void findSum(int[] candidate, int start, int target, List<Integer> tmp, List<List<Integer>> all){
		if(target == 0){
			List<Integer> one = new ArrayList<Integer>();
			one.addAll(tmp);
			all.add(one);
		}
		
		for(int i = start; i < candidate.length; i++){
			if(i > start && candidate[i] == candidate[i - 1]){
				continue;
			}
			if(candidate[i] <= target){
				tmp.add(candidate[i]);
				findSum(candidate, i + 1, target - candidate[i], tmp, all);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
