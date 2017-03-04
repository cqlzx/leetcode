package array;

import java.util.*;

public class SubsetsII {

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3};
		List<List<Integer>> res = subsetsWithDup(nums);
		for(List<Integer> one : res){
			System.out.println(one.toString());
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		Arrays.sort(nums);
		res.add(new ArrayList<>());
		
		for(int i = 1; i <= nums.length; i++){
			subsets(nums, 0, i, res, one);
		}
		
		return res;
	}
	
	public static void subsets(int[] nums, int start, int k, List<List<Integer>> res, List<Integer> one){
		if(k == 0){
			res.add(new ArrayList<>(one));
			return;
		}
		
		for(int i = start; i < nums.length - k + 1; i++){
			if(i == start || nums[i - 1] != nums[i]){
				one.add(nums[i]);
				subsets(nums, i + 1, k - 1, res, one);
				one.remove(one.size() - 1);
			}
		}
	}
}
