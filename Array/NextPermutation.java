package array;

import java.util.Arrays;

public class NextPermutation {
	public static void main(String args[]){
		int[] nums = {1, 5, 1};
		nextPermutation(nums);
		for(int num : nums){
			System.out.print(num + "->");	
		}
	}
	
	public static void nextPermutation(int[] nums){
		int len = nums.length;
		if(len == 0 || len == 1){
			return;
		}
		int k = len - 1;
		int temp = 0;
		
		if(nums[k] > nums[k - 1]){
			temp = nums[k - 1];
			nums[k - 1] = nums[k];
			nums[k] = temp;
			return;
		}
		
		while(nums[k] <= nums[k - 1]){
			k--;
			if(k == 0){
				Arrays.sort(nums);
				return;
			}
		}
		
		int i = k;
		int j = len - 1;
		while(i < j){
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			
			i++;
			j--;
		}
		
		int p = k - 1;
		while(nums[p] >= nums[k]){
			k++;
		}
		temp = nums[p];
		nums[p] = nums[k];
		nums[k] = temp;
		
		return;
	}
}
