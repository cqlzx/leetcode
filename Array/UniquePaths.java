package array;

public class UniquePaths {
	public static void main(String args[]){
		int res = uniquePaths(3, 3);
		System.out.println(res);
	}
	public static int uniquePaths(int m, int n){
		if(m == 1 && n == 1) return 1;
		int[][] node = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 && j == 0){
					continue;
				}else if(i == 0){
					node[i][j] = 1;
				}else if(j == 0){
					node[i][j] = 1;
				}else{
					node[i][j] = node[i - 1][j] + node[i][j - 1];
				}
			}
		}
		
		return node[m - 1][n - 1];
	}
}
