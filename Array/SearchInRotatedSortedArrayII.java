package array;

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		int[] nums = {1, 3, 1, 1, 1, 1, 1, 1};
		boolean res = search(nums, 3);
		System.out.println(res);
	}

	public static boolean search(int[] nums, int target){
		int start = 0;
		int end = nums.length - 1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] == target){
				return true;
			}
			
			if(nums[start] < nums[mid]){
				if(nums[start] <= target && target < nums[mid]){
					end = mid - 1;
				}else{
					start = mid + 1;
				}
			}else if(nums[mid] < nums[end]){
				if(nums[mid] < target && target <= nums[end]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}else{
				if(nums[start] == target) return true;
				start++;
			}
		}
		
		return false;
	}
}
