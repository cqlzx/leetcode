package string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		int len = lengthOfLastWord("Hello world   ");
		System.out.println(len);
	}

	public static int lengthOfLastWord(String s){
		int len = 0;
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) != ' '){
				len++;
			}else{
				if(len != 0){
					return len;
				}
			}
		}
		return len;
	}
}
