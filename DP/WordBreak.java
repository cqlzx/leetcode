package dp;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int r = 1; r <= n; r++) {
            for (int i = 0; i < r; i++) {
                String sub = s.substring(i, r);
                if (dict.contains(sub) && dp[i]) {
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
