package math;

public class DivideTwoIntegers {
	public static void main(String args[]){
		int x = 1;
		int y = -1;
		int result = divide(x, y);
		System.out.println(result);
	}
	
	public static int divide(int dividend, int divisor){
		if(divisor == 1){
			return dividend;
		}
		boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0); 
		long abDividend = Math.abs((long)dividend);
		long abDivisor = Math.abs((long)divisor);
		
		long res = 0;
		while(abDividend >= abDivisor){
			long count = 1;
			long current = abDivisor;
			while(current <= abDividend >> 1){
				count = count << 1;
				current = current << 1;
			}
			
			abDividend -= current;
			res += count;
		}
		
		if(res > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else{
			return positive ? (int)res : -(int)res;
		}
	}
}
