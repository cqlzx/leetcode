package tree;

public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		return helper(root, 0, "");
	}
	
	public int helper(TreeNode root, int sum, String cur) {
		if (root.left == null && root.right == null) {
			int tmp = Integer.valueOf(cur + root.val);
			return sum + tmp;
		}
		
		int left = 0, right = 0;
		if (root.left != null) left = helper(root.left, sum, cur + root.val);
		if (root.right != null) right = helper(root.right, sum, cur + root.val);
		
		return sum + left + right;
	}
}
