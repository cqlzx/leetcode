package string;

import java.util.*;

public class RepeatedDNASequences {

	//Solution 1, same idea as Sol. 2 but more clean
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>();
		Set<String> repeated = new HashSet<>();
		for (int i = 0 ; i < s.length() - 9; i++) {
			String cur = s.substring(i, i + 10);
			if(!seen.add(cur)) {
				repeated.add(cur);
			}
		}
		return new ArrayList<>(repeated);
	}
	
	//Solution 2, not fast
	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		if (s.length() < 10) return res;
		
		String cur = s.substring(0, 10);
		map.put(cur, 1);
		for (int i = 10; i < s.length(); i++) {
			cur = cur.substring(1, 10) + s.charAt(i);
			if (!map.containsKey(cur)) {
				map.put(cur, 1);
			} else {
				int times = map.get(cur);
				if (times > 1) continue;
				else {
					res.add(cur);
					map.put(cur, 2);
				}
			}
		}
		return res;
	}
}
