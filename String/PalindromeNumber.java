package string;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x = 12300;
		boolean result = isPalindrome(x);
		System.out.println(result);
	}

	public static boolean isPalindrome(int x){
		if(x < 0){
			return false;
		}
		
		long y = 0;
		int temp = x;
		while(temp != 0){
			y = y * 10 + temp % 10;
			temp = temp / 10;
		}
		
		if(y > Integer.MAX_VALUE){
			return false;
		}else{
			temp = (int)y;
			if(temp == x){
				return true;
			}else{
				return false;
			}
		}
	}
}
