package string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"abc", "a", "ab"};
		String s = longestCommonPrefix(strs);
		System.out.println(s);
	}

	public static String longestCommonPrefix(String[] strs){
		if(strs.length == 0){
			return "";
		}
		String common = strs[0];
		for(int i = 1; i < strs.length; i++){
			if(strs[i].length() == 0){
				return "";
			}
			int length = common.length() < strs[i].length() ? common.length() : strs[i].length();
			for(int j = 0; j < length; j++){
				if(common.charAt(j) != strs[i].charAt(j)){
					common = common.substring(0, j);
					break;
				}
				
				if(j == strs[i].length() - 1){
					common = strs[i];
				}
			}
		}
		return common;
	}
}
