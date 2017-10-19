package bit;

import java.util.*;

public class MaximumXOROfTwoNumbersInAnArray {

	public static void main(String[] args) {
//		int res = new MaximumXOROfTwoNumbersInAnArray().findMaximumXOR(new int[]{3,10,5,25,2,8});
//		System.out.println(res);
		
		String a = "54321";
		String b = "321";
		String c = "44321";
		String d = "543";
		System.out.println(a.compareTo(b));
		System.out.println(a.compareTo(c));
		System.out.println(a.compareTo(d));
		
		System.out.println("---");
		System.out.println(1 % -2);
		System.out.println(-1 % -2);
	}

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            mask |= 1 << i;
            for (int num : nums) {
                set.add(mask & num);
            }
            
            int tmp = res | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
}
