package string;

import java.util.*;

public class WordLadder {

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		int res = ladderLength("hit", "cog", wordList);
		System.out.println(res);
	}

	
	public static int ladderLength(String beginWord, String endWord, List<String> wordAsList) {
        if(!wordAsList.contains(endWord)) return 0;
        
        Set<String> wordList = new HashSet<String>(wordAsList);
        Set<String> start = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        int length = 1;
        start.add(beginWord); end.add(endWord);
        wordList.remove(beginWord); wordList.remove(endWord);
        
        while(!start.isEmpty()){
            Set<String> next = new HashSet<String>();
            for(String word: start){
                char[] wordArray = word.toCharArray();
                for(int i=0; i<word.length(); i++){
                    char old = wordArray[i];
                    for(char c='a'; c<='z'; c++){
                        wordArray[i] = c;
                        String str = String.valueOf(wordArray);
                        if(end.contains(str))
                            return length+1;
                        if(wordList.contains(str)){
                            next.add(str);
                            wordList.remove(str);
                        }
                    }
                    wordArray[i] = old;
                }
            }
            start = next.size() < end.size() ? next: end;
            end = start.size() < end.size() ? end : next;
            length++;
        }
        return 0;
    }
	
	
	//Solution 2, time exceeds
	public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		int res = helper(beginWord, endWord, wordList);
		return res == 10000 ? 0 : res;
	}
	public static int helper(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.equals(endWord)) return 1;
		int res = 10000;
		for (int i = 0; i < wordList.size(); i++) {
			String cur = wordList.get(i);
			if (isClose(cur, beginWord)) {
				wordList.remove(i);
				res = Math.min(res,  helper(cur, endWord, wordList) + 1);
				wordList.add(i, cur);
			}
		}
		
		return res;
	}
	public static boolean isClose(String s1, String s2) {
		int dif = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				dif++;
			}
		}
		if (dif == 1) return true;
		return false;
	}
}
