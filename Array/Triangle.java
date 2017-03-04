package array;

import java.util.*;

public class Triangle {

	//Solution 1
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		int[][] res = new int[size][size];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			if (i == triangle.size() - 1) {
				for (int j = 0; j < row.size(); j++) {
					res[i][j] = row.get(j);
				}
				continue;
			}
			for (int j = 0; j < row.size(); j++) {
				res[i][j] = Math.min(res[i + 1][j], res[i + 1][j + 1]) + row.get(j);
			}
		}
		
		return res[0][0];
	}
	
	//Solution 2, O(n) space
	public int minimumTotal2(List<List<Integer>> triangle) {
		int[] res = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			for (int j = 0; j < row.size(); j++) {
				res[j] = Math.min(res[j], res[j + 1]) + row.get(j);
			}
		}
		
		return res[0];
	}
}
