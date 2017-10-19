package array;

public class HouseRobber {

	//Solution 1, DP
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		if (nums.length == 0) return 0;
		if (nums.length > 0) dp[0] = nums[0];
		if (nums.length > 1) dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
		for (int i = 2; i < nums.length; i++) {
			int tmp = dp[i - 2] + nums[i];
			if (tmp > dp[i - 1]) dp[i] = tmp;
			else dp[i] = dp[i - 1];
		}
		return dp[nums.length - 1];
	}
	
	//Solution 2, O(1) space DP
	public int rob2(int[] nums) {
	    int prevNo = 0;
	    int prevYes = 0;
	    for (int n : nums) {
	        int temp = prevNo;
	        prevNo = Math.max(prevNo, prevYes);
	        prevYes = n + temp;
	    }
	    return Math.max(prevNo, prevYes);
	}
}
