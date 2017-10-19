package other;


public class WordDictionary {
    
	private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode p = root;
    	
        for (int i = 0; i < word.length(); i++) {
        	TrieNode tmp = p.children[word.charAt(i) - 'a'];
        	if (tmp == null) {
        		tmp = new TrieNode();
        		p.children[word.charAt(i) - 'a'] = tmp;
        	}
        	p = tmp;
        }
        
        p.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return search(word, 0, root); 
    }
    
    private boolean search(String word, int index, TrieNode root) {
    	if (root == null) return false;
    	if (index == word.length() && root.isEnd) return true;
    	if (index == word.length() && !root.isEnd) return false;
    	
    	char tmp = word.charAt(index);
    	if (tmp != '.') {
    		if (root.children[tmp - 'a'] == null) return false;
    		else return search(word, index + 1, root.children[tmp - 'a']);
    	} else {
    		for (int i = 0; i < 26; i++) {
    			boolean res = search(word, index + 1, root.children[i]);
    			if (res) return true;
    		}
    	}
    	return false;
    }

//  //Time exceeds
//	List<String> words = new ArrayList<>();
//    /** Initialize your data structure here. */
//    public WordDictionary() {
//        
//    }
//    
//    /** Adds a word into the data structure. */
//    public void addWord(String word) {
//        words.add(word);
//    }
//    
//    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//    public boolean search(String word) {
//        for (String s : words) {
//        	if (s.length() != word.length()) continue;
//        	
//        	int i = 0;
//        	for (i = 0; i < s.length(); i++) {
//        		if (s.charAt(i) == word.charAt(i) || word.charAt(i) == '.') continue;
//        		if (s.charAt(i) != word.charAt(i)) break;
//        	}
//        	
//        	if (i == s.length()) return true;
//        }
//        
//        return false;
//    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */