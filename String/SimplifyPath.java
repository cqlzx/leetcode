package string;

import java.util.*;

public class SimplifyPath {

	public static void main(String[] args){
		String res = simplifyPath("/./..//a/b/../c/.");
		System.out.println(res);
	}
	
	//Using deque is more convenient and recommended
	public static String simplifyPath(String path){
		Deque<String> stack = new LinkedList<>();
		for(String p : path.split("/")){
			if(p.equals(".") || p.equals("")){
				continue;
			}else if(p.equals("..")){
				stack.pollLast();
			}else{
				stack.offer(p);
			}
		}
	
		String res = "";
		for(String s : stack){
			res += "/" + s;
		}
		
		return res.isEmpty() ? "/" : res;
	}
}
