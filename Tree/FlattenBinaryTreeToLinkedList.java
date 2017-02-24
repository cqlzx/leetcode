package tree;

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root){ 
		helper(root, null);
	}
	
	public static TreeNode helper(TreeNode root, TreeNode pre){
		if(root == null) return pre;
		pre = helper(root.right, pre);
		pre = helper(root.left, pre);
		root.right = pre;
		root.left = null;
		pre = root;
		return pre;
	}
}
