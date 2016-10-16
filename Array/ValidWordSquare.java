package ninthContest;

import java.util.ArrayList;
import java.util.List;

public class ValidWordSquare {
	public static void main(String args[]){
		List<String> words = new ArrayList<String>();
		words.add("ball");
		words.add("asee");
		words.add("let");
		words.add("lep");
		
		boolean b = validWordSquare(words);
		System.out.println(b);
	}
	
	public static boolean validWordSquare(List<String> words){
		for(int i = 0; i < words.size(); i++){
			String row = words.get(i);
			int len = row.length();
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < words.size(); j++){
				if(j >= len){
					break;
				}
				if(i >= words.get(j).length()){
					break;
				}
				sb.append(words.get(j).charAt(i));
			}
			String column = sb.toString();
			if(!row.equals(column)){
				return false;
			}
		}
		
		return true;
	}
}
