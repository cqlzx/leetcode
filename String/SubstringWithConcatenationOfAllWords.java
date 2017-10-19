package string;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
//		String s = "barfoothefoobarman";
//		String[] words = {"foo", "bar"};
//		List<Integer> res = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
	}
	
    public List<Integer> findSubstring1(String s, String[] words) {
        if (s == null || s.length() == 0 || words.length == 0) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        
        int len = words[0].length();
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> tmpMap = new HashMap<>(map);
            int count = 0;
            int start = i, end = i + len * words.length;
            while (start < end) {
                String sub = s.substring(start, start + len);
                if (tmpMap.containsKey(sub) && tmpMap.get(sub) > 0) {
                    start += len;
                    tmpMap.put(sub, tmpMap.get(sub) - 1);
                    count++;
                } else {
                    break;
                }
            }
            
            if (count == words.length) res.add(i);
        }
        
        return res;
    }
    
    public List<Integer> findSubstring2(String s, String[] words) {
        if (words.length == 0 || s.length() == 0) return new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (helper(s, words.length, i, map, 0)) {
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean helper(String s, int n, int start, Map<String, Integer> map, int count) {
        if (count == n) return true;
        if (start >= s.length()) return false;
        
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (map.containsKey(sub) && map.get(sub) > 0) {
                map.put(sub, map.get(sub) - 1);
                if (helper(s, n, i + 1, map, count + 1)) {
                    map.put(sub, map.get(sub) + 1);
                    return true;
                }
                map.put(sub, map.get(sub) + 1);
            }
        }
        return false;
    }
}
