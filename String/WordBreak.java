package string;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("lee");
		wordDict.add("leet");
		wordDict.add("tcode");
		System.out.println(wordBreak("leetcode", wordDict));
	}
	
	
	//Solution 1, using dp
	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> words = new HashSet<>(wordDict);
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (res[j] && words.contains(s.substring(j, i))) {
					res[i] = true;
					break;
				}
			}
		}
		return res[s.length()];
	}
	

	
	//Solution 2, time exceeds
	public static boolean wordBreak2(String s, List<String> wordDict) {
		Set<String> words = new HashSet<>(wordDict);
		return canBreak(s, words);
	}
	public static boolean canBreak(String s, Set<String> words) {
		if (s.length() == 0) return true;
		boolean res = false;
		for (int i = 1; i <= s.length(); i++) {
			String part1 = s.substring(0, i);
			if (words.contains(part1)) {
				res = res || canBreak(s.substring(i, s.length()), words);
			}
		}
		return res;
	}
}
