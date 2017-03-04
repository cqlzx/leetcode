package array;

public class FindPeakElement {

	//Binary search
	public int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		
		while (low < high) {
			int mid1 = low + (high - low) / 2;
			int mid2 = mid1 + 1;
			if (nums[mid1] < nums[mid2]) {
				low = mid2;
			} else {
				high = mid1;
			}
		}
		
		return low;
	}
	
	//Sequential search
	public int findPeakElement2(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) return i - 1;
		}
		return nums.length - 1;
	}
	
	//Bad sequential search
	public int findPeakElement3(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (i + 1 < nums.length && nums[i + 1] < nums[i]) {
					return i;
				}
			}
			
			if (i - 1 >= 0 && i + 1 < nums.length) {
				if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
					return i;
				}
			}
			
			if (i == nums.length - 1) {
				if (i - 1 >= 0 && nums[i] > nums[i - 1]) {
					return i;
				}
			}
		}
		
		return 0;
	}
}
