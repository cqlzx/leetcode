package tree;

public class MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode root){
		return deep(root, 0);
	}
	
	public static int deep(TreeNode root, int deep){
		if(root != null){
			return Math.max(deep(root.left, deep + 1), deep(root.right, deep + 1));
		}
		return deep;
	}
}
