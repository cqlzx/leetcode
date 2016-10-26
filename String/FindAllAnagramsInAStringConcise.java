package tenthContest;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAStringConcise {
	public static void main(String args[]){
		List<Integer> res = findAnagrams("abab", "ab");
		System.out.println(res.toString());
	}
	
	public static List<Integer> findAnagrams(String s, String p){
		List<Integer> res = new ArrayList<Integer>();
		int[] actual = new int[26];
		int[] expect = new int[26];
		
		for(int i = 0; i < p.length(); i++){
			expect[p.charAt(i) - 'a']++;
		}
		
		for(int j = 0; j < s.length(); j++){
			actual[s.charAt(j) - 'a']++;
			
			if(j >= p.length()){
				actual[s.charAt(j - p.length()) - 'a']--;
			}
			
			boolean flag = true;
			for(int k = 0; k < 26; k++){
				if(actual[k] != expect[k]){
					flag = false;
					break;
				}
			}
			
			if(flag){
				res.add(j - p.length() + 1);
			}
		}
		
		return res;
	}
}
