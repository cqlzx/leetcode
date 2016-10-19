package eighthContest;

//import java.util.Arrays;

public class PartitionEqualSubsetSum {
	public static void main(String args[]){
//		int[] nums = {71,70,66,54,32,63,38,98,4,22,61,40,6,8,6,21,71,36,30,34,44,60,89,53,60,56,73,14,63,37,15,58,51,88,88,32,80,32,10,89,67,29,68,65,34,15,88,8,57,78,37,63,73,65,47,39,32,74,31,44,43,4,10,8,96,22,58,87,29,99,79,13,96,21,62,71,34,55,72,3,96,7,36,64,30,6,14,87,12,90,40,13,29,21,94,33,99,86,4,100};
//		int[] nums2 = {1, 2, 3, 5, 7};
		//dp[sum] overflow
		int[] nums3 = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
		System.out.println(canPartition(nums3));
	}
	
	//The problem can be changed into find target sum in nums
	//dp[sum] is the number of subset, it may overflow
	public static boolean canPartition(int[] nums){
		int sum = 0;
		for(int num : nums){
			sum += num;
		}
		
		if(sum % 2 == 1){
			return false;
		}
		
		sum /= 2;
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		int currentSum = 0;
		for(int num : nums){
			currentSum += num;
			for(int i = Math.min(sum, currentSum); i >= num; i--){
				dp[i] += dp[i - num];
			}
		}
		
		return dp[sum] != 0 ? true : false;
	}
	
//	//wrong answer
//	public static boolean canPartition(int[] nums){
//		int len = nums.length;
//		int sum = 0;
//		int half = 0;
//		for(int i = 0; i < len; i++){
//			sum += nums[i];
//		}
//		if(sum % 2 == 1){
//			return false;
//		}else{
//			half = sum / 2;
//		}
//		
//		Arrays.sort(nums);
//		
//		return findNumber(half, nums, 0, len - 1);
//	}
//	
//	public static boolean findNumber(int target, int[] arr, int start, int end){		
//		for(int i = end; i >= start; i--){
//			if(arr[i] > target){
//				continue;
//			}else if(arr[i] == target){
//				return true;
//			}else{
//				System.out.println(arr[i] + " | " + target);
//				return findNumber(target - arr[i], arr, start, i - 1);
//			}
//		}
//		
//		return false;
//	}
}
