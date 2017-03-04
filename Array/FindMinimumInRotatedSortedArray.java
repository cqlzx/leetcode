package array;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {6,7,1,2,3,4};
		int res = findMin(nums);
		System.out.println(res);
	}
	
	//Iteration Solution
	public static int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;
		
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return nums[start];
	}
	
	
	//Recursion Solution
	public static int findMin2(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	
	public static int helper(int[] nums, int start, int end) {
		if (start >= end) return nums[start];
		int min;
		int mid = (end - start) / 2 + start;
		if (nums[mid] < nums[end]) {
			min = Math.min(nums[mid], helper(nums, start, mid - 1));
		} else {
			min = Math.min(nums[end], helper(nums, mid + 1, end));
		}
		return min;
	}
	
	
	//Not good enough
	public int findMin3(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		return min;
	}
}
