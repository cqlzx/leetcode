package array;

public class TwoSumII {

	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int p = 0, q = numbers.length - 1;
		while (p < q) {
			if (numbers[p] + numbers[q] < target) {
				p++;
			} else if (numbers[p] + numbers[q] > target) {
				q--;
			} else {
				res[0] = p + 1;
				res[1] = q + 1;
				break;
			}
		}
		return res;
	}
}
