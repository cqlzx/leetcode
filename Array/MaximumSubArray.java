package array;

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] nums = {1, -2, 1, 3, -3, 4, 5, 7};
		int ans = maxSubArray(nums);
		System.out.println(ans);
	}

	public static int maxSubArray(int[] nums){
		int len = nums.length;
		int[] dp = new int[len];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++){
			if(i > 0 && dp[i - 1] > 0){
				dp[i] = dp[i - 1] + nums[i];
			}else{
				dp[i] = nums[i];
			}
			
			max = dp[i] >= max ? dp[i] : max;
		}
		
		return max;
	}
}
