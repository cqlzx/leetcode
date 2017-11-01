package dp;

import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        return helper(s, dict, map);
    }
    
    private List<String> helper(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> res = new ArrayList<>();
        
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        
        for (int i = 0; i < s.length(); i++) {
            String sub1 = s.substring(0, i + 1);
            String sub2 = s.substring(i + 1);
            if (dict.contains(sub1)) {
                List<String> list = helper(sub2, dict, map);
                for (String next : list) {
                    res.add(sub1 + (next.length() == 0 ? "" : " ") + next);
                }
            }
        }
        
        map.put(s, res);
        return res;
    }

}
