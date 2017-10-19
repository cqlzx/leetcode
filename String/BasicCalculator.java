package string;

public class BasicCalculator {

	public static void main(String[] args) {
		String s = "(5-(1+(5)))";
		System.out.println(new BasicCalculator().calculate(s));
		
	}
	
	public int calculate(String s) {
        s = s.replaceAll(" ", "");
        return helper(s);
    }
    
    private int helper(String s) {
        int left = -1, right = -1;
        int i = 0, tmpRes = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') left = i;
            else if (s.charAt(i) == ')') {
                right = i;
                tmpRes = cal(s.substring(left + 1, right));
                break;
            }
            i++;
        }
        if (i == s.length()) {
            return cal(s);
        } else {
            String newStr = s.substring(0, left) + tmpRes + s.substring(right + 1);
            return helper(newStr);
        }
    }
    
    private int cal(String s) {
        s = s.replaceAll("--", "+");
        s = s.replaceAll("-", "+-");
        String[] numbers = s.split("\\+");
        int res = 0;
        for (String num : numbers) {
            res += Integer.parseInt(num);
        }
        return res;
    }

}
