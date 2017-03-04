package array;

public class MinimumSizeSubarraySum {
	public static void main(String args[]){
		int[] nums = {2, 3, 1, 2, 4, 3};
		int s = 7;
		int res = minSubArrayLen(s, nums);
		System.out.println(res);
 	}
	
	public static int minSubArrayLen(int s, int[] nums){
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(end <= nums.length){
			if(sum >= s){
				min = Integer.min(min, end - start);
				sum -= nums[start];
				start++;
			}else{
				if(end == nums.length){
					break;
				}
				sum += nums[end];	
				end++;
			}
		}
		
		if(min == Integer.MAX_VALUE){
			return 0;
		}
		
		return min;
	}
}
