package binarySearch;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int mySqrt(int x) {
        long start = 0, end = x;
        while (start < end) {
            long mid = (end - start) / 2 + start + 1;
            if (mid * mid == x) return (int) mid;
            else if (mid * mid < x) start = mid;
            else end = mid - 1;
        }
        return (int) start;
    }
}
