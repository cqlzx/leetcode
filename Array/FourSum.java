package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		int len = nums.length;
		for(int m = 0; m < len - 3; m++){
			if(m == 0 || nums[m] != nums[m - 1]){
				for(int n = m + 1; n < len - 2; n++){
					if(n == m + 1 || nums[n] != nums[n - 1]){
						int i = n + 1, j = len - 1;
						int newTarget = target - nums[m] - nums[n];
						while(i < j){
							int sum = nums[i] + nums[j];
							if(sum == newTarget){
								List<Integer> list = new ArrayList<Integer>();
								list.add(nums[m]);
								list.add(nums[n]);
								list.add(nums[i]);
								list.add(nums[j]);
								l.add(list);
								
								i++;
								j--;
								while(i < j && nums[i] == nums[i - 1]){
									i++;
								}
								while(i < j && nums[j] == nums[j + 1]){
									j--;
								}
							}else if (sum > newTarget){
								j--;
							}else{
								i++;
							}
						}
					}
				}
			}
			
		}
		
		return l;
	}
}
