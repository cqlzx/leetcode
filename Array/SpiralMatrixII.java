package array;

public class SpiralMatrixII {

	public static void main(String[] args) {
		int[][] res = generateMatrix(0);
		for(int i = 0; i < res.length; i++){
			for(int j = 0; j < res[0].length; j++){
				System.out.print("(" + res[i][j] + ")");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n){
		int len = n * n;
		int i = 0, j = 0;
		int[][] res = new int[n][n];
		int state = 1;
		for(int k = 1; k <= len; k++){
			switch(state){
				case 1 : 
					if(j + 1 >= n || res[i][j + 1] != 0){
						state = 2;
						res[i++][j] = k;
					}else{
						res[i][j++] = k;
					}
					break;
				case 2 :
					if(i + 1 >= n || res[i + 1][j] != 0){
						state = 3;
						res[i][j--] = k;
					}else{
						res[i++][j] = k;
					}
					break;
				case 3 :
					if(j - 1 < 0 || res[i][j - 1] != 0){
						state = 4;
						res[i--][j] = k;
					}else{
						res[i][j--] = k;
					}
					break;
				case 4 :
					if(i - 1 < 0 || res[i - 1][j] != 0){
						state = 1;
						res[i][j++] = k;
					}else{
						res[i--][j] = k;
					}
					break;
			}
		}
		
		return res;
	}
}
