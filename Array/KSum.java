package array;

import java.util.*;

public class KSum {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,4,5,5,6};
		List<List<Integer>> res = new KSum().kSum(nums, 3, 10);
		for (List<Integer> list : res) {
			System.out.println(list.toString());
		}
	}

	public List<List<Integer>> kSum(int[] nums, int k, int target) {
		Arrays.sort(nums);
		return helper(nums, k, 0, target);
	}
	
	private List<List<Integer>> helper(int[] nums, int k, int index, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (k == 2) {
			int i = index, j = nums.length - 1;
			while (i < j) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					List<Integer> items = new ArrayList<>();
					items.add(nums[i]);
					items.add(nums[j]);
					res.add(items);
					while (i < j && nums[i] == nums[i + 1]) i++;
					while (i < j && nums[j] == nums[j - 1]) j--;
					i++;
					j--;
				} else if (sum > target) {
					j--;
				} else {
					i++;
				}
			}
		} else {
			for (int i = index; i < nums.length - k + 1; i++) {
				if (i > index && nums[i] == nums[i - 1]) continue;
				
				List<List<Integer>> lastResults = helper(nums, k - 1, i + 1, target - nums[i]);
				
				for (List<Integer> items : lastResults) {
					items.add(0, nums[i]);
				}
				
				res.addAll(lastResults);
			}
		}
		
		return res;
	}
}
