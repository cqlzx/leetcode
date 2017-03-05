package string;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams2(strs);
		for(List<String> list : res){
			System.out.println(list.toString());
		}
	}

	public static List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs){
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String key = new String(tmp);
			List<String> list = map.get(key);
			if(list == null){
				list = new ArrayList<String>();
			}
			list.add(str);
			map.put(key, list);
		}
		
		List<List<String>> res = new ArrayList<>();
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			List<String> list = entry.getValue();
			Collections.sort(list);
			res.add(list);
		}
		
		return res;
	}
	
	public static List<List<String>> groupAnagrams2(String[] strs){
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs){
			char[] tmp = "00000000000000000000000000".toCharArray();
			String key = "";
			for(char ch : str.toCharArray()){
				int index = ch - 'a';
				tmp[index]++;
			}
			key = new String(tmp);
			
			List<String> list = map.get(key);
			if(list == null){
				list = new ArrayList<String>();
			}
			list.add(str);
			map.put(key, list);
		}
		
		List<List<String>> res = new ArrayList<>();
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			List<String> list = entry.getValue();
			Collections.sort(list);
			res.add(list);
		}
		
		return res;
	}
}
