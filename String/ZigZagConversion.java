package leetcode;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "A";
		String str = convert(s, 1);
		System.out.println(str);
	}
	
	public static String convert(String s, int numRows){
		if(numRows == 1){
			return s;
		}
		
		int size = 2 * (numRows - 1);
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < numRows; i++){
			for(int j = i; j < s.length(); j += size){
				sb.append(s.charAt(j));
				if(i != 0 && i != numRows - 1){
					int temp = j + size - 2 * i;
					if(temp < s.length()){
						sb.append(s.charAt(temp));						
					}
				}
			}
		}
		
		return sb.toString();
	}

}
