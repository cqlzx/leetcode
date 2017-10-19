package array;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		List<List<Integer>> res = new ThreeSum().threeSum(new int[]{-1,0,1,-1,2,-1,-4});
		for (List<Integer> items : res) {
			System.out.println(items.toString());
		}

	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
        	if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (-nums[k] == nums[i] + nums[j]) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;
                    i++;
                    j--;
                } else if (-nums[k] > nums[i] + nums[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return res;
    }
}
