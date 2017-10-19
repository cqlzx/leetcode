package string;

import java.util.*;

public class IsomorphicStrings {

	public static void main(String[] args) {
		boolean res = isIsomorphic2("aba", "baa");
		System.out.println(res);
	}

	//Solution 1, not fast
	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> smap = new HashMap<>();
		Map<Character, Character> cmap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (smap.containsKey(sc)) {
				if (smap.get(sc) != tc) return false;
			} 
			
			if (cmap.containsKey(tc)){
				if (cmap.get(tc) != sc) return false;
			}
			
			smap.put(sc, tc);
			cmap.put(tc, sc);
		}
		return true;
	}
	
	//Solution 2, assume the characters are all ASCII
	public static boolean isIsomorphic2(String s, String t) {
		int[] sa = new int[512], ta = new int[512];
		for (int i = 0; i < s.length(); i++) {
			if (sa[s.charAt(i)] != ta[t.charAt(i)]) return false;
			//The idea is very good
			sa[s.charAt(i)] = i + 1;
			ta[t.charAt(i)] = i + 1;
		}
		return true;
	}
}
