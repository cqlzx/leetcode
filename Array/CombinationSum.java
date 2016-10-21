package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static void main(String args[]){
		int[] candidate = new int[] {2, 3, 6, 7};
		List<List<Integer>> res = combinationSum(candidate, 7);
		for(List<Integer> list : res){
			System.out.println(list.toString());
		}
	}
	
	public static List<List<Integer>> combinationSum(int[] candidate, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();
		Arrays.sort(candidate);
		if(candidate.length == 0){
			return res;
		}
		
		findSum(candidate, 0, target, row, res);
		
		return res;
	}
	
	public static void findSum(int[] candidate, int start, int target, List<Integer> one, List<List<Integer>> all){
		if(target == 0){
			List<Integer> tmp = new ArrayList<Integer>();	//one is the shadow copy, must new instance to add
			tmp.addAll(one);
			all.add(tmp);
			return;
		}
		
		for(int i = start; i < candidate.length; i++){
			if(i > start && candidate[i] == candidate[i - 1]){
				continue;
			}
			if(candidate[i] <= target){
				one.add(candidate[i]);
				findSum(candidate, i, target - candidate[i], one, all);
				one.remove(one.size() - 1);
			}
		}
	}
}
