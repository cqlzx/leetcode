package tree;

public class PathSum {
	
	//Solution 1
	public static boolean hasPathSum(TreeNode root, int sum){
		if(root == null) return false;
		return helper(root, sum);
	}
	public static boolean helper(TreeNode root, int sum){
		if(root.left == null && root.right == null){
			if(sum == root.val){
				return true;
			}else{
				return false;
			}
		}
		
		if(root.left == null) return helper(root.right, sum - root.val);
		if(root.right == null) return helper(root.left, sum - root.val);
		
		return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
	}
	
	
	
	//Solution 2
	public static boolean hasPathSum2(TreeNode root, int sum){
		if(root == null) return false;
		if(root.left == null && root.right == null && root.val == sum) return true;
		return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
	}
}
