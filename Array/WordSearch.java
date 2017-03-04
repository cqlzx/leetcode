package array;

public class WordSearch {

	public static void main(String[] args){
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//		char[][] board = {{'a'}};
		boolean res = exist(board, "ABCCEESB");
		System.out.println(res);
	}
	
	//Change String into char array can reduce time
	public static boolean exist(char[][] board, String word){
		char[] wd = word.toCharArray();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(exist(board, wd, 0, i, j))
					return true;
			}
		}
		
		return false;
	}
	
	//Check the border when it has reached, not before.(i.e. row < 0, not row > 0 && ...)
	public static boolean exist(char[][] board, char[] word, int pos, int row, int col){
		if(pos == word.length) return true;
		if(row < 0 || row == board.length || col < 0 || col == board[row].length) return false;
		if(word[pos] != board[row][col]) return false;
		
		board[row][col] = '*';
		
		boolean res = exist(board, word, pos + 1, row - 1, col)
				|| exist(board, word, pos + 1, row + 1, col)
				|| exist(board, word, pos + 1, row, col - 1)
				|| exist(board, word, pos + 1, row, col + 1);
		
		board[row][col] = word[pos];
		
		return res;
	}
}
