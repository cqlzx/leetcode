package array;

public class MaximalSquare {

	public static void main(String[] args) {
		int res = maximalSquare2(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
		System.out.println(res);
	}
	
	//Solution 1, brute force, O((mn)^2)
	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int minLen = Math.min(matrix.length, matrix[0].length);
		for (int l = minLen; l > 0; l--) {
			for (int i = 0; i <= matrix.length - l; i++) {
				for (int j = 0; j <= matrix[0].length - l; j++) {
					boolean hasSquare = true;
					for (int m = i; m < l + i; m++) {
						for (int n = j; n < l + j; n++) {
							if (matrix[m][n] == '0') {
								m = minLen + i;
								hasSquare = false;
								break;
							}
						}
					}
					if (hasSquare) return l * l;
				}
			}
		}
		return 0;
	}
	
	//Solution 2, DP, O(mn) time complexity
	public static int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int[][] dp = new int[matrix.length][matrix[0].length];
		int maxEdge = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j] - '0';
					maxEdge = Math.max(maxEdge, dp[i][j]);
					continue;
				}
				
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
					maxEdge = Math.max(maxEdge, dp[i][j]);
				}
			}
		}
		
		return maxEdge * maxEdge;
	}
}
