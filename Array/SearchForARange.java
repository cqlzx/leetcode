package array;

public class SearchForARange {
	public static void main(String args[]){
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] res = searchRange(nums, 8);
		
		for(int num : res){
			System.out.println(num);	
		}
	}
	
	public static int[] searchRange(int[] nums, int target){
		int index = find(nums, 0, nums.length - 1, target);
		
		int temp_start = index, res_start = -1;
		while(temp_start != -1){
			res_start = temp_start;
			temp_start = find(nums, 0, temp_start - 1, target);
		}
		
		int temp_end = index, res_end = -1;
		while(temp_end != -1){
			res_end = temp_end;
			temp_end = find(nums, temp_end + 1, nums.length - 1, target);
		}
		
		int[] res = {res_start, res_end};
		return res;
	}
	
	private static int find(int[] nums, int start, int end, int target){
		int middle = (start + end) / 2;
		
		if((start > end) || (start == end && nums[start] != target)){
			return -1;
		}
		
		if(nums[middle] == target){
			return middle;
		}
		
		if(nums[middle] > target){
			return find(nums, start, middle - 1, target);
		}else{
			return find(nums, middle + 1, end, target);
		}
	}
}
