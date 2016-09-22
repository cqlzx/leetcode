package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "dabcbf";
		String sub = longestPalindrome(s);
		System.out.println(sub);
	}
	
    public static String longestPalindrome(String s) {
    	int max = 0;
    	int start = 0;
    	int len = s.length();
    	boolean p[][] = new boolean[len][len];
    	for(int r = 0; r < len; r++){
    		for(int i = 0; i < len - r; i++){
    			if(r == 0 || r == 1){
    				p[i][i + r] = s.charAt(i) == s.charAt(i + r);
    			}else{
    				p[i][i + r] = p[i + 1][i + r - 1] && s.charAt(i) == s.charAt(i + r);
    			}
    			
    			if(p[i][i + r] == true && r > max){
    				start = i;
    				max = r;
    			}
//    			System.out.println(i + "==");
    		}
    	}
    	
    	
    	return s.substring(start, start + max + 1);
    }

}
