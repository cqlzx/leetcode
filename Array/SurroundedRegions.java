package array;

public class SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
					if (board[i][j] == 'O') change(board, i, j);
				}
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
				if (board[i][j] == '1') board[i][j] = 'O';
			}
		}
	}
	
	//No need to check the border
	public static void change(char[][] board, int i, int j) {
		if (board[i][j] == 'X' || board[i][j] == '1') return;
		board[i][j] = '1';
		if (i > 1) change(board, i - 1, j);
		if (i < board.length - 2) change(board, i + 1, j);
		if (j > 1) change(board, i, j - 1);
		if (j < board[0].length - 2) change(board, i, j + 1);
	}
}
