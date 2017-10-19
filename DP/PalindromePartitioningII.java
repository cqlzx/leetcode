package dp;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		int res = new PalindromePartitioningII().minCut("coder");
		System.out.println(res);
	}
	
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int r = 2; r <= n; r++) {
            for (int i = 0; i + r - 1 < n; i++) {
                int j = i + r - 1;
                if (isPalindrome(s, i, j)) {
                    dp[i][j] = 0;
                    continue;
                }
                int minCut = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    minCut = Math.min(minCut, dp[i][k] + dp[k + 1][j] + 1);  
                }
                dp[i][j] = minCut;
            }
        }
        return dp[0][n - 1];
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;   
        }
        return true;
    }
}
