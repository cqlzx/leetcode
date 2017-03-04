package array;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = {{1, 2, 10}, {4, 5, 6}, {7, 8, 9}};
		int res = minPathSum(grid);
		System.out.println(res);
	}

	public static int minPathSum(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int row = grid.length;
		int col = grid[0].length;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(i == 0 && j != 0){
					grid[i][j] += grid[i][j - 1];
				}else if(i != 0 && j == 0){
					grid[i][j] += grid[i - 1][j];
				}else if(i != 0 && j != 0){
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}
		
		return grid[row - 1][col - 1];
	}
}
