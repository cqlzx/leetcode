package other;

public class WordDictionaryTest {
	
    public static void main(String[] args) {	
    	WordDictionary wd = new WordDictionary();
    	wd.addWord("bad");
    	wd.addWord("dad");
    	wd.addWord("mad");
    	System.out.println(wd.search("pad"));
    	System.out.println(wd.search("bad"));
    	System.out.println(wd.search(".ad"));
    	System.out.println(wd.search("b.."));
    }
}
