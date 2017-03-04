package array;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {2, 7, 2, 1, 0, 1, 2, 3, 2};
		boolean can = canJump(nums);
		System.out.println(can);
	}
	
	public static boolean canJump(int[] nums){
		int reachable = 0;
		for(int i = 0; i < nums.length; i++){
			if(i > reachable) return false;
			reachable = Math.max(reachable, i + nums[i]);
		}
		
		return true;
	}
	
	//Using recursion, time exceeds.
	public static boolean canJump2(int[] nums){
		return jumpAt(0, nums);
	}
	
	public static boolean jumpAt(int index, int[] nums){
		if(index >= nums.length - 1){
			return true;
		}
		int step = nums[index];
		if(step == 0){
			return false;
		}
		while(step != 0){
			if(!jumpAt(index + step, nums)){
				step--;
			}else{
				return true;
			}
		}
		return false;
	}
}
