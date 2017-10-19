package array;

import java.util.*;

public class ContainsDuplicatesIII {

	public static void main(String[] args) {
		int[] nums = {-3, 3, 6};
		System.out.println(new ContainsDuplicatesIII().containsNearbyAlmostDuplicate(nums, 2, 3));
	}

	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long tmp = (long) nums[i] - Integer.MIN_VALUE;
            long key = tmp / ((long) t + 1);
            if (map.containsKey(key)) return true;
            if (map.containsKey(key - 1) && Math.abs(map.get(key - 1) - tmp) <= t) return true;
            if (map.containsKey(key + 1) && Math.abs(map.get(key + 1) - tmp) <= t) return true;
            map.put(key, tmp);
            if (i >= k) {
                long lastKey = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastKey);
            }
        }
        return false;
    }
}
