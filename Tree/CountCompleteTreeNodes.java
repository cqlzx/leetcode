package tree;

public class CountCompleteTreeNodes {

	//Solution 1, Recursive
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int height = checkHeight(root);
		int rightHeight = checkHeight(root.right);
		if (rightHeight == height - 1) {
			return countNodes(root.right) + (1 << height);
		} else {
			return countNodes(root.left) + (1 << height - 1);
		}
	}
	
	//Solution 2, Iterative
	public int countNodes2(TreeNode root) {
		if (root == null) return 0;
		TreeNode p = root;
		int count = 0;
		int h = checkHeight(p);
		while (p != null) {
			int rightHeight = checkHeight(p.right);
			if (rightHeight == h - 1) {
				count += (1 << h);
				p = p.right;
			} else {
				count += (1 << h - 1);
				p = p.left;
			}
			h--;
		}
		return count;
	}
	
	private int checkHeight(TreeNode root) {
		return root == null ? -1 : 1 + checkHeight(root.left);
	}
}
