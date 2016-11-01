package other;

public class TrieNode {
	TrieNode[] children;
	boolean isEnd;
	
	public TrieNode(){
		this.children = new TrieNode[26];
	}
}
