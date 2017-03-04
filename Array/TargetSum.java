package array;

import java.util.*;

public class TargetSum {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		int res = findTargetSumWays(nums, 3);
		System.out.println(res);
	}

	//Solution 1, recursive
	public static int findTargetSumWays(int[] nums, int S) {
		return findTargetHelper(nums, 0, S);
	}
	public static int findTargetHelper(int[] nums, int index, int target) {
		if (index == nums.length && target == 0) return 1;
		if (index == nums.length) return 0;
		return findTargetHelper(nums, index + 1, target - nums[index]) + findTargetHelper(nums, index + 1, target + nums[index]);
	}
	
	//Solution 2. Time exceeds
	public static int findTargetSumWays2(int[] nums, int S) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(-nums[0]);
		res.add(nums[0]);
		for (int i = 1 ; i < nums.length; i++) {
			int len = res.size();
			for (int j = 0; j < len; j++){
				res.add(res.get(j) + nums[i]);
				res.set(j, res.get(j) - nums[i]);
			}
		}
		
		int ans = 0;
		for (Integer i : res) {
			if(i == S) ans++;
		}
		
		return ans;
	}
}
