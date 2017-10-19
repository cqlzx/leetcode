package array;

import java.util.*;

public class WordSearchII {

	public static void main(String[] args) {
		char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "eat", "rain"};
		List<String> res = new WordSearchII().findWords(board, words);
		System.out.println(res.toString());
	}

	
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res);
			}
		}
		
		return res;
	}
	private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == '*' || p.children[c - 'a'] == null) return;
		p = p.children[c - 'a'];
		
		if (p.word != null) {
			res.add(p.word);
			p.word = null;
		}
		
		board[i][j] = '*';
		
		if (i > 0) dfs(board, i - 1, j, p, res);
		if (j > 0) dfs(board, i, j - 1, p, res);
		if (i < board.length - 1) dfs(board, i + 1, j, p, res);
		if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
		
		board[i][j] = c;
	}
	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode p = root;
			for (char c : word.toCharArray()) {
				int i = c - 'a';
				if (p.children[i] == null) p.children[i] = new TrieNode();
				p = p.children[i];
			}
			p.word = word;
		}
		
		return root;
	}
	
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Solution 2, based on WordSearchI, time exceeds
	public static List<String> findWords2(char[][] board, String[] words) {
		Set<String> setWords = new HashSet<>(Arrays.asList(words));
		Set<String> set = new HashSet<>();
		for (String word : setWords) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					helper(board, word, 0, i, j, set);
				}
			}
		}
		return new ArrayList<String>(set);
	}
	private static void helper(char[][] board, String word, int pos, int row, int col, Set<String> set) {
		if (pos == word.length()){
			set.add(word);
			return;
		}
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
		
		char tmp = board[row][col];
		if (word.charAt(pos) != tmp) return;
		board[row][col] = '*';
		
		helper(board, word, pos + 1, row + 1, col, set);
		helper(board, word, pos + 1, row - 1, col, set);
		helper(board, word, pos + 1, row, col + 1, set);
		helper(board, word, pos + 1, row, col - 1, set);
		
		board[row][col] = tmp;
	}
}
