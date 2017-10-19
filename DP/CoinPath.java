package dp;

import java.util.*;

public class CoinPath {

	public static void main(String[] args) {
//		int[] A = new int[]{0,0,0,0,0,0};
		int[] A = new int[]{1,2,4,-1,2,3,6,9,6,5,7};
//		int[] A = new int[]{0,-1,0,0,0,0};
//		int[] A = {28,44,71,-1,99,59,78,60,80,18,71,1,68,6,19,66,62,74,7,67,18,70,22,15,6,58,95,26,52,38,80,60,34,56,9,8,34,3,25,33,45,35,15,27,97,22,2,2,71,91,44,28,91,93,25,2,53,54,15,14,56,97,51,36,81,29,15,58,97};
//		int[] A = new int[]{1};
//		int[] A = new int[]{0,-1,-1,-1,-1,-1};
		List<Integer> res = new CoinPath().cheapestJump(A, 3);
		System.out.println(res);
	}
	
    public List<Integer> cheapestJump(int[] A, int B) {
        if (A[A.length - 1] == -1) return new ArrayList<>();
        if (A.length == 1) return Arrays.asList(1);
        int n = A.length;
        int[] dp = new int[n + 1];
        int[] path = new int[n + 1];

        dp[n] = A[n - 1];
        path[n] = n + 1;
        for (int i = n - 1; i >= 1; i--) {
            dp[i] = Integer.MAX_VALUE;

            if (A[i - 1] == -1) continue;

            for (int j = 1; j <= B; j++) {
                if (i + j > n) continue;

                if (dp[i + j] < dp[i]) {
                    dp[i] = dp[i + j];
                    path[i] = i + j;
                }
            }

            dp[i] = dp[i] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i] + A[i - 1];
        }

        List<Integer> res = new ArrayList<>();
        if (dp[1] == Integer.MAX_VALUE) return res;

        int index = 1;
        while (index <= n) {
            res.add(index);
            index = path[index];
        }

        return res;
    }
}
