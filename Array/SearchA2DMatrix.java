package array;

public class SearchA2DMatrix {
	public static void main(String[] args){
		int[][] matrix = {{1}, {3}};
		boolean res = searchMatrix(matrix, 5);
		System.out.println(res);
	}
	
	//There is a shorter solution on leetcode
	public static boolean searchMatrix(int[][] matrix, int target){
		if(matrix.length == 0) return false;
		int row = 0;
		int start = 0, end = matrix.length - 1;
		while(true){
			int mid = (start + end) / 2;
			if(matrix[mid][0] <= target){
				if(mid == matrix.length - 1 || matrix[mid + 1][0] > target){
					row = mid;
					break;
				}
				start = mid + 1;
			}else{
				if(mid == 0){
					return false;
				}
				end = mid - 1;
			}
		}
	
		start = 0;
		end = matrix[0].length - 1;
		while(true){
			int mid = (start + end) / 2;
			if(matrix[row][mid] == target){
				return true;
			}else if(matrix[row][mid] < target){
				if(mid == matrix[0].length - 1 || matrix[row][mid + 1] > target){
					return false;	
				}
				start = mid + 1;
			}else{
				if(mid == 0){
					return false;
				}
				end = mid - 1;
			}
		}
	}
}
