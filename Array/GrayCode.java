package array;

import java.util.*;

public class GrayCode {

	public static void main(String[] args) {
		List<Integer> res = grayCode(3);
		System.out.println(res.toString());
	}

	public static List<Integer> grayCode(int n){
		List<Integer> res = new ArrayList<>();
		res.add(0);
		for(int i = 0; i < n; i++){
			//pow can be replaced by 1 << i
			int dif = 1 << i;
			for(int j = 1; j <= dif; j++){
				int tmp = res.get(dif - j);
				res.add(tmp + dif);
			}
		}
		
		return res;
	}
}
