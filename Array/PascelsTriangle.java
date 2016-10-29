package array;

import java.util.*;

public class PascelsTriangle {
	public static void main(String args[]){
		List<List<Integer>> res = generate(0);
		for(List<Integer> list : res){
			System.out.println(list.toString());
		}
	}
	
	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(numRows == 0) return list;
		List<Integer> first = new ArrayList<Integer>();
		first.add(1);
		list.add(first);
		
		for(int i = 1; i < numRows; i++){
			List<Integer> row = new ArrayList<>();
			row.add(1);
			List<Integer> last = list.get(list.size() - 1);
			for(int j = 1; j < last.size(); j++){
				int tmp = last.get(j - 1) + last.get(j);
				row.add(tmp);
			}
			row.add(1);
			list.add(row);
		}
		
		return list;
	}
}
