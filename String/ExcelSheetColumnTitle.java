package string;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		String res = convertToTitle(52);
		System.out.println(res);
	}
	
	
	//Solution 1, so short
	public static String convertToTitle(int n) {
		return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
	}
	
	//Solution 2
	public static String convertToTitle2(int n) {
		int times = 1;
		n--;
		while (Math.pow(26, times) <= n) {
			n -= Math.pow(26, times);
			times++;
		}
		
		String res = "";
		while (times > 0) {
			int tmp = (int) Math.pow(26, --times);
			int number = n / tmp;
			res += (char)('A' + number);
			n %= tmp;
		}
		
		return res;
	}
}
