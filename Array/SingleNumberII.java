package array;

public class SingleNumberII {

	//Using bit manipulation, consider it as state machine, each state has two bit
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int num : nums) {
			ones = (ones ^ num) & ~twos;
			twos = (twos ^ num) & ~ones;
		}
		return ones;
	}
}
