package string;

public class MultiplyStrings {
	public static void main(String args[]){
		String sum1 = "123";
		String sum2 = "456";
		String res = multiply(sum1, sum2);
		System.out.println(res);
	}
	
	public static String multiply(String sum1, String sum2){		
		String sum1_rev = new StringBuilder(sum1).reverse().toString();
		String sum2_rev = new StringBuilder(sum2).reverse().toString();
		
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < sum1_rev.length() + sum2_rev.length(); k++){
			sb.append("0");
		}
		
		for(int i = 0; i < sum1_rev.length(); i++){
			int carry = 0;
			for(int j = 0; j < sum2_rev.length(); j++){
				carry += (sum1_rev.charAt(i) - '0') * (sum2_rev.charAt(j) - '0') + sb.charAt(i + j) - '0';
				int digit = carry % 10;
				sb.replace(i + j, i + j + 1, digit + "");
				carry /= 10;
			}
			
			if(carry != 0){
				sb.replace(i + sum2_rev.length(), i + sum2_rev.length() + 1, carry + "");
			}
		}
		sb.reverse();
		int count = 0;
		while(sb.charAt(count) == '0' && count < sb.length() - 1){
			count++;
		}
		sb.delete(0, count);
		
		return sb.toString();
	}
}
