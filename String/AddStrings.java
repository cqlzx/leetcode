package eighthContest;

public class AddStrings {
	public static void main(String args[]){
		String s1 = "6994";
		String s2 = "36";
		String sum = addStrings(s1, s2);
		System.out.println(sum);
	}
	
	public static String addStrings(String num1, String num2){
		if(num1.length() > num2.length()){
			String num3 = num2;
			num2 = num1;
			num1 = num3;
		}
		StringBuffer sb = new StringBuffer();
		int len = num1.length();
		int dis = num2.length() - num1.length();
		int decimal = 0, digit = 0;
		for(int i = len - 1; i >= 0; i--){
			int temp = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(i + dis)) + decimal;
			decimal = temp / 10;
			digit = temp % 10;
			sb.insert(0, digit);
		}
		
		for(int j = dis - 1 ; j >= 0; j--){
			int temp = Character.getNumericValue(num2.charAt(j)) + decimal;
			decimal = temp / 10;
			digit = temp % 10;
			sb.insert(0, digit);
		
//			System.out.println(digit);
	
		}
		
		if(decimal > 0){
			sb.insert(0, 1);
		}
		
		return sb.toString();
	}
}
