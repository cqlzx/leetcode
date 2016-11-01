package other;

public class Trie {
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String word){
		TrieNode p = root;
		
		for(int i = 0; i < word.length(); i++){
			TrieNode tmp = p.children[word.charAt(i) - 'a'];
			if(tmp == null){
				tmp = new TrieNode();
				p.children[word.charAt(i) - 'a'] = tmp;
			}
			
			p = tmp;
		}
		
		p.isEnd = true;
	}
	
	public boolean search(String word){
		TrieNode tmp = searchNode(word);
		if(tmp != null && tmp.isEnd == true){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean startsWith(String prefix){
		TrieNode tmp = searchNode(prefix);
		if(tmp != null){
			return true;
		}else{
			return false;
		}
	}
	
	public TrieNode searchNode(String word){
		TrieNode p = root;
		
		for(int i = 0; i < word.length(); i++){
			TrieNode tmp = p.children[word.charAt(i) - 'a'];
			if(tmp == null){
				return tmp;
			}else{
				p = tmp;
			}
		}
		
		return p;
	}
}
