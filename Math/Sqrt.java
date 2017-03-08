package math;

public class Sqrt {

	public static void main(String[] args) {
		int res = mySqrt(0);
		System.out.println(res);
	}

	//if use mid * mid > x, the multiply result will overflow and the infinite loop will get time exceeded
	public static int mySqrt(int x){
		if(x == 0) return 0;
		int start = 1;
		int end = x;
		while(true){
			int mid = (start + end) / 2;
			if(mid > x / mid){
				end = mid - 1;
			}else if(mid + 1 > x / (mid + 1)){
				return mid;
			}else{
				start = mid + 1;
			}
		}
	}
}
