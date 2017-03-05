package string;

public class DecodeWays {

	public static void main(String[] args) {
		int res = numDecoding("110");
		System.out.println(res);
	}

	public static int numDecoding(String s){
		if(s.length() == 0) return 0;
		char[] nums = s.toCharArray();
		int[] dp = new int[nums.length + 1];
		dp[0] = 1;
		dp[1] = nums[0] == '0' ? 0 : 1;
		for(int i = 1; i < nums.length; i++){
			if((nums[i - 1] == '1' && nums[i] != '0') || (nums[i - 1] == '2' && nums[i] <= '6' && nums[i] > '0')){
				dp[i + 1] = dp[i] + dp[i - 1];	
			}else{
				if(nums[i] == '0'){
					if(nums[i - 1] != '1' && nums[i - 1] != '2'){
						return 0;
					}else{
						dp[i + 1] = dp[i - 1];
					}
				}else{
					dp[i + 1] = dp[i];	
				}
			}
		}
		
		return dp[nums.length];
	}
	
	//12351221
	//Almost but not working
//	public static int numDecoding(String s){
//		if(s.equals("")) return 0;
//		int total = 0;
//		char[] nums = s.toCharArray();
//		for(int i = 0; i < nums.length; i++){
//			if(i == 0){
//				if(nums[i] == '0'){
//					return 0;
//				}else{
//					total++;
//					continue;
//				}
//			}
//			
//			if((nums[i - 1] == '1' && nums[i] != '0') || (nums[i - 1] == '2' && nums[i] <= '6' && nums[i] > '0')){
//				total++;
//			}
//			
//			if(nums[i] == '0'){
//				if(nums[i - 1] != '1' && nums[i - 1] != '2'){
//					return 0;
//				}else{
//					if(total > 1) total--;
//				}
//			}
//		}
//		
//		return total;
//	}
}
