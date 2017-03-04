package array;

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 2, 3};
		int res = removeDuplicates(nums);
		System.out.println(res);
		for(int i = 0; i < res; i++){
			System.out.println(nums[i]);
		}
	}

	public static int removeDuplicates(int[] nums){
		int shown = 0;
		int count = 0;
		int pos = 0;
		for(int i = 0; i < nums.length; i++){
			if(i == 0){
				count++;
				continue;
			}
			
			if(nums[i - 1] == nums[i]){
				if(shown == 0){
					nums[++pos] = nums[i];
					count++;
					shown++;
				}
			}else{
				nums[++pos] = nums[i];
				count++;
				shown = 0;
			}
		}
		
		return count;
	}
}
