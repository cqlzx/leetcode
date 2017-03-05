package string;

import java.util.*;

public class ReverseWordInAString {

	//Solution 1, good but slow
	public String reverseWords(String s) {
		String[] parts = s.trim().split("\\s+");
		String out = "";
		for (int i = parts.length - 1; i > 0; i--) {
		    out += parts[i] + " ";
		}
		return out + parts[0];	
	}
	
	//Solution 2, simple and fast
	public String reverseWords2(String s) {
		String[] words = s.trim().split(" ");
		List<String> list = new ArrayList<>();
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].equals("")) continue;
			list.add(words[i]);
		}
		return String.join(" ", list);
	}
	
	
	//Solution 3, too slow, but advanced
	public String reverseWords3(String s) {
		String[] words = s.trim().split(" ");
		List<String> wordList = new ArrayList<>(Arrays.asList(words));
		wordList.removeIf(word -> word.equals(""));
		Collections.reverse(wordList);
		return String.join(" ", wordList);
	}
}
