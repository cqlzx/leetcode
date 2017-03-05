package string;

public class ReverseString {

	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}
}
