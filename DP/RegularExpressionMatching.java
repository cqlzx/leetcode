package dp;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMatch(String s, String p) {
        int m = p.length(), n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= m; i++) {
            if (p.charAt(i - 1) == '*') dp[i][0] = dp[i - 2][0];
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = p.charAt(i - 1);
                if (c == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
                } else {
                    boolean tmp = p.charAt(i - 2) == '.' || p.charAt(i - 2) == s.charAt(j - 1);
                    dp[i][j] = dp[i - 2][j] || dp[i][j - 1] && tmp;
                }
            }
        }
        
        return dp[m][n];
    }
}
