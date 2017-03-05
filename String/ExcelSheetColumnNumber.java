package string;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("AZ"));
	}
	
	public static int titleToNumber(String s) {
		char[] titles = s.toCharArray();
		int res = 0, len = titles.length;
		for (int i = 0; i < titles.length; i++) {
			int tmp = (int) Math.pow(26, --len);
			int factor = titles[i] - 'A' + 1;
			res += tmp * factor;
		}
		
		return res;
	}
}
