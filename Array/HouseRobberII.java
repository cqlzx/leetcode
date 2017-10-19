package array;

public class HouseRobberII {

	public static void main(String[] args) {
		int res = rob(new int[]{3,2,6,5,7,1,4});
		System.out.println(res);
	}
	
	//Solution 1, straightforward dp, rob first or rob last
	public static int rob(int[] nums) {
		if (nums == null || nums.length ==0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		
		int[] robFirst = new int[nums.length - 1];
		int[] robLast = new int[nums.length - 1];
		
		robFirst[0] = nums[0];
		robFirst[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length - 1; i++) {
			robFirst[i] = Math.max(robFirst[i - 1], robFirst[i - 2] + nums[i]);
		}
		
		robLast[0] = nums[1];
		robLast[1] = Math.max(nums[1], nums[2]);
		for (int i = 3; i < nums.length; i++) {
			robLast[i - 1] = Math.max(robLast[i - 2], robLast[i - 3] + nums[i]);
		}
		
		return Math.max(robFirst[nums.length - 2], robLast[nums.length - 2]);
	}
	
	//Solution 2, the helper can be used generally.
	public int rob2(int[] nums) {
	    if (nums.length == 1) return nums[0];
	    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}
	private int rob(int[] num, int lo, int hi) {
	    int include = 0, exclude = 0;
	    for (int j = lo; j <= hi; j++) {
	        int i = include, e = exclude;
	        include = e + num[j];
	        exclude = Math.max(e, i);
	    }
	    return Math.max(include, exclude);
	}
	
}
