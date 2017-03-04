package array;

public class SingleNumber {

	//Using XOR to find the single.
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}
}
