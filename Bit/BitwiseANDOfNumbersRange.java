package bit;

public class BitwiseANDOfNumbersRange {

	public static void main(String[] args) {
		int res = rangeBitwiseAnd3(2147483646, 2147483647);
		System.out.println(res);
	}
	
	//Solution 1, brute force, time exceeds
	public int rangeBitwiseAnd(int m, int n) {
		int res = m;
		for (int i = m + 1; i <= n; i++) {
			res &= i;
		}
		return res;
	}
	
	//Solution 2, little optimization
	public int rangeBitwiseAnd2(int m, int n) {
		int res = m;
		int start = m, end = n;
		while (start <= end) {
			res &= (start++ & end--);
			if (res == 0) return 0;
		}
		return res;
	}
	
	//Solution 3, recursion
	public static int rangeBitwiseAnd3(int m, int n) {
		return helper(m, n, 0);
	}
	private static int helper(int start, int end, int cur) {
		if (start == 0) return cur;
		int count = 1;
		int start_tmp = start, end_tmp = end;
		while (start_tmp > 1) {
			start_tmp >>= 1;
			end_tmp >>= 1;
			count <<= 1;
		}
		if (end_tmp > 1) return cur;
		return helper(start - count, end - count, cur + count);
	}
	
	//Solution 4, nice idea
    public int rangeBitwiseAnd4(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
