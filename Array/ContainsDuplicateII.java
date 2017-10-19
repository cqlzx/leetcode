package array;

import java.util.*;

public class ContainsDuplicateII {

	//Solution 1, hash map
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				if (i - index <= k) return true;
			}
			map.put(nums[i], i);
		}
		
		return false;
	}
	
	//Solution 2, hash set
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0 ; i < nums.length; i++) {
			if (i > k) set.remove(nums[i - k - 1]);
			if (!set.add(nums[i])) return true;
		}
		
		return false;
	}
}
