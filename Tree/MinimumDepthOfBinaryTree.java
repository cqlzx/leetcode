package tree;

public class MinimumDepthOfBinaryTree {
	
	//Solution 1
	public int minDepth(TreeNode root){
		if(root == null) return 0;
		return helper(root, 1);
	}
	public static int helper(TreeNode root, int depth){
		if(root.left == null && root.right == null) return depth;
		if(root.left == null) return helper(root.right, depth + 1);
		if(root.right == null) return helper(root.left, depth + 1);
		
		return Math.min(helper(root.left, depth + 1), helper(root.right, depth + 1));
	}
	
	
	
	//Solution 2
	public int minDepth2(TreeNode root){
		if(root == null) return 0;
		if(root.left == null) return minDepth(root.right) + 1;
		if(root.right == null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
