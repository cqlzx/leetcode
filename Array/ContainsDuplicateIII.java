package array;

import java.util.*;

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		boolean res = containsNearbyAlmostDuplicate3(new int[]{-1, 2147483647}, 1, 2147483647);
		System.out.println(res);
	}
	
	//Time exceeds
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			int bound = Math.min(nums.length, i + k + 1);
			for (int j = i + 1; j < bound; j++) {
				long res = (long) nums[i] - (long) nums[j];
				if (Math.abs(res) <= t) return true;
			}
		}
		return false;
	}
	
	//Solution 1, Use BST, O(NlogK)
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			Long floor = set.floor((long) nums[i]);
			Long ceiling = set.ceiling((long) nums[i]);
			
			if ((floor != null && t >= nums[i] - floor) || (ceiling != null && ceiling - nums[i] <= t)) {
				return true;
			}
			
			set.add((long) nums[i]);
			if (i >= k) {
				set.remove((long) nums[i - k]);
			}
		}
		
		return false;
	}
	
	//Solution 2, using bucket, O(N)
	public static boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
		if (k <= 0 || t < 0) return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			
			if (map.containsKey(bucket) 
					|| map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t
					|| map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t) {
				return true;
			}
			
			if (map.entrySet().size() >= k) {
				map.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1));
			}
			
			map.put(bucket, remappedNum);
		}
		
		return false;
	}
}
