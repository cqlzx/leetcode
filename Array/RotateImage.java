package array;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		rotate(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j =0; j < matrix[0].length; j++){
				System.out.print("(" + matrix[i][j] + ")");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix){
		int n = matrix.length;
		
		int row = n / 2;
		int col = n / 2 + n % 2;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				int i_tmp = j;
				int j_tmp = n - 1 - i;
				int tmp = matrix[i][j];
				for(int k = 0; k < 4; k++){
					int value = matrix[i_tmp][j_tmp];
					matrix[i_tmp][j_tmp] = tmp;
					tmp = value;
					
					int edge_tmp = i_tmp;
					i_tmp = j_tmp;
					j_tmp = n - 1 - edge_tmp;
				}
			}
		}
	}
}
