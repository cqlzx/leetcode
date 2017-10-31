package dfs;

import java.util.*;

public class WordSearchII {

	public static void main(String[] args) {
		char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		String[] words = {"oath","pea","eat","rain"};
		List<String> res = new WordSearchII().findWords(board, words);
		System.out.println(res.toString());
	}
	
	public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words.length == 0) return new ArrayList<>();
        
        TrieNode root = buildTrie(words);
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return new ArrayList<>(res);
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode p, Set<String> set) {
        char c = board[i][j];
        if (c == '*' || p.children[c - 'a'] == null) return;
        if (p.children[c - 'a'].word != null) {
            set.add(p.children[c - 'a'].word);
        }
        
        board[i][j] = '*';
        if (i > 0) dfs(board, i - 1, j, p.children[c - 'a'], set);
        if (j > 0) dfs(board, i, j - 1, p.children[c - 'a'], set);
        if (i < board.length - 1) dfs(board, i + 1, j, p.children[c - 'a'], set);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p.children[c - 'a'], set);
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();    
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
