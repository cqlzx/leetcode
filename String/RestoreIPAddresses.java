package string;

import java.util.*;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		String s = "010010";
		List<String> res = restoreIpAddresses(s);
		System.out.println(res.toString());
	}

	//Solution 1, using dfs
	public static List<String> restoreIpAddresses(String s){
		List<String> res = new ArrayList<>();
		helper(s, 0, 0, "", res);
		return res;
	}
	public static void helper(String s, int start, int segment, String one, List<String> res){
		if(segment >= 4){
			if(start >= s.length()) res.add(one.substring(0, one.length() - 1));
			return;
		}
		
		for(int i = 1; i < 4; i++){
			if(start + i > s.length()) return;
			String num = s.substring(start, start + i);
			if(Integer.valueOf(num) >= 0 && Integer.valueOf(num) < 256){
				if(num.startsWith("0") && num.length() != 1) continue;
				one = one + num + ".";
				helper(s, start + i, segment + 1, one, res);
				one = one.substring(0, one.length() - i - 1);
			}
		}
	}
	
	
	//Solution 2, using for loop
	public static List<String> restoreIpAddresses2(String s){
		List<String> ret = new ArrayList<>();
		
		StringBuffer ip = new StringBuffer();
		for(int a = 1 ; a < 4 ; ++ a)
		for(int b = 1 ; b < 4 ; ++ b)
	    for(int c = 1 ; c < 4 ; ++ c)
		for(int d = 1 ; d < 4 ; ++ d)
		{
			if(a + b + c + d == s.length())
			{
				int n1 = Integer.parseInt(s.substring(0, a));
				int n2 = Integer.parseInt(s.substring(a, a+b));
				int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
				int n4 = Integer.parseInt(s.substring(a+b+c));
				if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
				{
					ip.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);
					if(ip.length() == s.length() + 3) ret.add(ip.toString());
					ip.delete(0, ip.length());
				}
			}
		}
		return ret;
	}
}
