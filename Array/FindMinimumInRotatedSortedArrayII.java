package array;

public class FindMinimumInRotatedSortedArrayII {
	
	//Iteration
	public int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (high - low) / 2 + low; 
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else if (nums[mid] < nums[high]) {
				high = mid; 
			} else {
				high--;
			}
		}
		return nums[low];
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
		} else if(nums[mid] == nums[end]) {
			min = helper(nums, start, end - 1);
		} else {
			min = Math.min(nums[end], helper(nums, mid + 1, end));
		}
		return min;
	}
}
