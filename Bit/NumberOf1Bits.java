package bit;

public class NumberOf1Bits {
	
	public static void main(String[] args) { 
		int res = hammingWeight(Integer.MIN_VALUE);
		System.out.println(res);
	}

	public static int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			count += n & 1;
			n >>>= 1;	
		}
		return count;
	}
}
