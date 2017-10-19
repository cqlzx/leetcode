package dp;

public class WildCardMatching {

	public static void main(String[] args) {
		boolean res = new WildCardMatching().isMatch("ab", "*");
		System.out.println(res);

	}

    public boolean isMatch(String s, String p) {
        int m = p.length(), n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
                } else {
                    for (int k = j; k >= 0; k--) {
                    	dp[i][j] |= dp[i - 1][k];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
