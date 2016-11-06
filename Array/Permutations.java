package array;

import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = permute(nums);
		for(List<Integer> one : res){
			System.out.println(one.toString());
		}
	}

	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> all = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		boolean[] flag = new boolean[nums.length];
		addPermutations(nums, flag, one, all);
		
		return all;
	}
	
	public static void addPermutations(int[] nums, boolean[] flag, List<Integer> one, List<List<Integer>> all){
		if(one.size() == nums.length){
			List<Integer> tmp = new ArrayList<>(one);
			all.add(tmp);
			return;
		}
		
		for(int i = 0; i < nums.length; i++){
			if(flag[i]) continue;
			one.add(nums[i]);
			flag[i] = true;
			addPermutations(nums, flag, one, all);
			one.remove(one.size() - 1);
			flag[i] = false;
		}
	}
}
