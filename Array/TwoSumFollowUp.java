package array;

import java.util.*;

public class TwoSumFollowUp {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = new TwoSumFollowUp().twoSum(new int[]{2, 11, 7, 15, 7, -2, -6, 7, 7}, 14);
		for (ArrayList<Integer> one : res) {
			System.out.println(one.toString());
		}

	}

	public ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		int start = 0, end = nums.length - 1;
		while (start < end) {
			
			while (start < end && nums[start] + nums[end] < target || start > 0 && nums[start] == nums[start - 1]) start++;
			
			while (start < end && nums[start] + nums[end] > target || end < nums.length - 1 && nums[end] == nums[end + 1]) end--;

			if (start < end && nums[start] + nums[end] == target) {
				ArrayList<Integer> one = new ArrayList<>();
				one.add(nums[start++]);
				one.add(nums[end--]);
				res.add(one);
			}
		}

		return res;
	}
}
