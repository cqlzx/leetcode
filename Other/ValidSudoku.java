package other;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidSudoku(char[][] board){
		HashSet<Character> hs = new HashSet<Character>();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(hs.contains(board[i][j]) && board[i][j] != '.'){
					return false;
				}else{
					hs.add(board[i][j]);
				}
			}
			hs.clear();
		}
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(hs.contains(board[j][i]) && board[j][i] != '.'){
					return false;
				}else{
					hs.add(board[j][i]);
				}
			}
			hs.clear();
		}
		
		for(int i = 0; i < 9; i += 3){
			for(int j = 0; j < 9; j += 3){
				for(int m = i; m < i + 3; m++){
					for(int n = j; n < j + 3; n++){
						if(hs.contains(board[m][n]) && board[m][n] != '.'){
							return false;
						}else{
							hs.add(board[m][n]);
						}
					}
				}
				hs.clear();
			}
		}
		
		return true;
	}
}
