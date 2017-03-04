package array;

import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> res = spiralOrder(matrix);
		System.out.println(res.toString());
	}

	public static List<Integer> spiralOrder(int[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0){
			return new ArrayList<Integer>();
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] state = new int[row][col];
		state[0][0] = 1;
		int i = 0, j = 0;
		boolean loop = true;
		List<Integer> res = new ArrayList<>();
		while(loop){
			switch(state[i][j]){
				case 1 :
					res.add(matrix[i][j]);
					if(j + 1 >= col || state[i][j + 1] != 0){
						if(i + 1 >= row || state[i + 1][j] != 0){
							loop = false;
							break;
						}
						state[++i][j] = 2;
					}else{
						state[i][++j] = 1;
					}
					break;
				case 2 :
					res.add(matrix[i][j]);
					if(i + 1 >= row || state[i + 1][j] != 0){
						if(j - 1 < 0 || state[i][j - 1] != 0){
							loop = false;
							break;
						}
						state[i][--j] = 3;
					}else{
						state[++i][j] = 2;
					}
					break;
				case 3 : 
					res.add(matrix[i][j]);
					if(j - 1 < 0 || state[i][j - 1] != 0){
						if(i - 1 < 0 || state[i - 1][j] != 0){
							loop = false;
							break;
						}
						state[--i][j] = 4;
					}else{
						state[i][--j] = 3;
					}
					break;
				case 4 : 
					res.add(matrix[i][j]);
					if(i - 1 < 0 || state[i - 1][j] != 0){
						if(j + 1 >= col || state[i][j + 1] != 0){
							loop = false;
							break;
						}
						state[i][++j] = 1;
					}else{
						state[--i][j] = 4;
					}
					break;
			}
		}
		
		return res;
	}
}
