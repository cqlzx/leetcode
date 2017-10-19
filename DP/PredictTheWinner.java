package dp;

public class PredictTheWinner {

	public static void main(String[] args) {
		boolean res = new PredictTheWinner().predictTheWinner(new int[]{1,5,2});
		System.out.println(res);
	}
	
    public boolean predictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) return true;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = nums[i];
        for (int r = 1; r < n; r++) {
            for (int j = n - 1; j >= r; j--) {
                int i = j - r;
                dp[j] = Math.max(nums[j] - dp[j - 1], nums[i] - dp[j]);
            }
        }
        return dp[n - 1] >= 0;
    }
}
