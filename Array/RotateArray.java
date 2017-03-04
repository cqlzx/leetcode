package array;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		rotate2(nums, 2);
		for (int num : nums) {
			System.out.print(num + ",");
		}
	}
	
	//Solution 1, reverse 3 times
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverseArray(nums, 0, nums.length - 1);
		reverseArray(nums, 0, k - 1);
		reverseArray(nums, k, nums.length - 1);
	}
	private static void reverseArray(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
	
	//Solution 2, Cyclic replacement
	public static void rotate2(int[] nums, int k) {
		int n = nums.length;
		if (n == 0 || k < 0) return;
		k = k % n;
		int count = 0;
		for (int i = 0; count < n; i++) {
			int before = i;
			int cur = nums[before];
			do {
				int after = (before + k) % n;
				int tmp = nums[after];
				nums[after] = cur;
				cur = tmp;
				before = after;
				count++;
			} while (before != i);
		}
	}
	
	//Solution 3, using extra O(n) space
	public static void rotate3(int[] nums, int k) {
		int len = nums.length;
		if (len == 0 || k < 0) return;
		k = k % len;
		int[] rotated = new int[len];
		for (int i = 0;i < len; i++) {
			int index = (i + k) % len;
			rotated[index] = nums[i];
		}
		
		for (int i = 0; i < len; i++) {
			nums[i] = rotated[i];
		}
	}
}
