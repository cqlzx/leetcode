package string;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "piqggbgobwsoktwoquqkarzfyyfdxukmfasl";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}

	
	public static int lengthOfLongestSubstring(String s){
		int j = 0;
		int max = 0;
		StringBuffer sb = new StringBuffer();
		int len = s.length();
		for(int i = 0; i < len; i++){
			int flag = i;
			do{
				if(j == s.length()){
//					System.out.println("======");
					return max;
				}
				for(int m = 0; m < sb.length(); m++){
					if(sb.charAt(m) != s.charAt(j)){
						continue;
					}else{
						sb.delete(0, m + 1);
						i = i + 1;
						break;
					}
				}
//				System.out.println(sb + "+" + s.charAt(j));
				sb.append(s.charAt(j));
				j++;
				max = max > sb.length() ? max : sb.length();
			}while(flag == i);
//			System.out.println(i);
		}
		
		return max;
	}
}
