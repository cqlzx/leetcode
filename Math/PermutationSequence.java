package math;

public class PermutationSequence {
	public static void main(String args[]){
		String s = getPermutation(9, 5);
		System.out.println(s);
	}
	
	public static String getPermutation(int n, int k){
		String s = "";
		for(int i = 1; i <= n; i++){
			s = s + i;
		}
		
		for(int j = 0; j < k - 1; j++){
			StringBuilder sb = new StringBuilder();
			int p = n - 1;
			if(s.charAt(p) > s.charAt(p - 1)){
				sb.insert(0, s.substring(0, p - 1));
				sb.append(s.charAt(p) + "" + s.charAt(p - 1));
				s = sb.toString();
				continue;
			}
			while(s.charAt(p) < s.charAt(p - 1)){
				p--;
			}
			
			int q = p - 1;
			p = n - 1;
			while(s.charAt(q) > s.charAt(p)){
				p--;
			}
			
			sb.insert(0, s.substring(0, q) + s.charAt(p));
			s = s.replace(s.charAt(p), s.charAt(q));
			
			for(int i = n - 1; i > q; i--){
				sb.append(s.charAt(i));
			}
			
			s = sb.toString();
		}
		
		return s;
	}
}
