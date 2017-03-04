package array;

import java.util.*;

public class MajorityElement {

	//Solution 1, Moore voting
	public int majorityElement(int[] nums) {
		int major = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				major = nums[i];
				count++;
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}
	
	//Solution 2, HashMap, not fast
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > nums.length / 2) {
				return entry.getKey();
			}
		}
		return 0;
	}
	
	//Solution 3, sorting
	public int majorityElement3(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
