package array;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {5, 6, 7, 8, 9, 1, 2};
		int res = search(nums, 9);
		System.out.println(res);
	}

	public static int search(int[] nums, int target){
		int start = 0;
		int end = nums.length - 1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] == target){
				return mid;
			}
			
			if(nums[start] <= nums[mid]){
				if(nums[start] <= target && target < nums[mid]){
					end = mid - 1;
				}else{
					start = mid + 1;
				}
			}
			
			if(nums[mid] <= nums[end]){
				if(nums[mid] < target && target <= nums[end]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
		}
		
		return -1;
	}
}
