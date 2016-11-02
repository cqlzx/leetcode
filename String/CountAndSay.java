package string;

public class CountAndSay {
	public static void main(String args[]){
		String s = countAndSay(5);
		System.out.print(s);
	}
	/*
	 * 35
	 * 1315
	 * 11131115
	 * 31133115
	 * 1321232115
	 */
	
	public static String countAndSay(int n){
		StringBuffer cur_sb = new StringBuffer();
		String s = "1";
		for(int i = 0; i < n - 1; i++){
			int len = s.length();
			int index = 0;
			int count = 1;
			while(index < len){
				if(index < len - 1 && s.charAt(index) == s.charAt(index + 1)){
					count++;
				}else{
					cur_sb.append(String.valueOf(count) + s.charAt(index));
					count = 1;
				}
				index++;
			}
			s = cur_sb.toString();
			cur_sb.delete(0, cur_sb.length());
		}
		
		return s;
	}
}
