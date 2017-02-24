package tree;

public class BalancedBinaryTree {

	public static boolean isBalanced(TreeNode root){
		if(root == null) return true;
		int left = deep(root.left, 1);
		int right = deep(root.right, 1);
		if(left - right > 1 || left - right < -1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static int deep(TreeNode root, int depth){
		if(root != null){
			return Math.max(deep(root.left, depth + 1), deep(root.right, depth + 1));
		}
		return depth;
	}
}
