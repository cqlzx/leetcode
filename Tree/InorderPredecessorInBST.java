package tree;

public class InorderPredecessorInBST {

	public static void main(String[] args) {

	}

	public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		if (root == null) return null;
		TreeNode predecessor;
		if (root.val >= p.val) {
			predecessor = inorderPredecessor(root.left, p);
		} else {
			predecessor = inorderPredecessor(root.right, p);
			if (predecessor == null) predecessor = root;
		}
		return predecessor;
	}
}
