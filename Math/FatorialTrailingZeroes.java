package math;

public class FatorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(25));
	}
	
	//Solution 1
	public static int trailingZeroes(int n) {
		int res = 0;
		while (n > 0) {
			n /= 5;
			res += n;
		}
		return res;
	}
	
	//Solution 2
	public static int trailingZeroes2(int n) {
		int count = 0, tmp = n;
		while (tmp >= 5) {
			tmp /= 5;
			count++;
		}
		
		int res = 0;
		for (int i = 1; i <= count; i++) {
			int one = n / (int) Math.pow(5, i);
			res += one ;
		}
		return res;
	}
}
