package tree;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		int res = numTrees(19);
		System.out.println(res);
	}

	//Solution 1, using dynamic programming
	public static int numTrees(int n){
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= i; j++){
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
	
	
	
	//Solution 2, using recursive, time limit exceeded when n = 19
	public static int numTrees2(int n){
		int total = numTrees(1, n);
		return total;
	}
	public static int numTrees(int start, int end){
		if(start >= end) return 1;
		int total = 0;
		for(int i = start; i <= end; i++){
			total += numTrees(start, i - 1) * numTrees(i + 1, end);	
		}
		return total;
	}
}
