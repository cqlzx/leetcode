package math;

public class ValidNumber {

	public static void main(String[] args) {
		boolean res = new ValidNumber().isNumber(" 3.2e2");
		System.out.println(res);
	}
	
	public boolean isNumber(String s) {
        s = s.trim();
        
        boolean numSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numSeen = true;
            } else if (s.charAt(i) == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
	}

}
