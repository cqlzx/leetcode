package array;

import java.util.*;

public class ContainsDuplicate {

	//Solution 1, sort
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) return true;
		}
		return false;
	}
	
	//Solution 2, hash table
	public boolean containsDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) return true;
			set.add(num);
		}
		return false;
	}
}
