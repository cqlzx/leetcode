package array;

public class SortColors {

	public static void main(String[] args) {
		int[] nums = {0, 1};
		sortColors(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}

	//Straight forward two-pass algorithm, thinking about the one-pass.
	public static void sortColors(int[] nums){
		int len = nums.length;
		int zero = 0, one = 0;
		for(int i = 0; i < len; i++){
			if(nums[i] == 0)
				zero++;
			else if(nums[i] == 1)
				one++;
		}
		
		for(int i = 0; i < zero; i++){
			nums[i] = 0;
		}
		for(int i = zero; i < one + zero; i++){
			nums[i] = 1;
		}
		for(int i = one + zero; i < len; i++){
			nums[i] = 2;
		}
	}
}
