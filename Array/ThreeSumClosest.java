package array;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int threeSumClosest(int[] nums, int target){
		Arrays.sort(nums);
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int closest = 0;
		
		for(int p = 0; p < len - 2; p++){
			int i = p + 1, j = len - 1;
			
			while(i < j){
				int sum = nums[p] + nums[i] + nums[j];
				int temp = sum - target;
				if(temp == 0){
					return target;
				}else{
					if(Math.abs(temp) < Math.abs(min)){
						min = temp;
						closest = sum;
					}
				}
				
				if(temp < 0){
					i++;
				}else{
					j--;
				}
			}
		}
		
		return closest;
	}
}
