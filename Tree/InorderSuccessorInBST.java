package tree;

public class InorderSuccessorInBST {

	public static void main(String[] args) {
		
	}
	
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode successor;
        if (root.val <= p.val) {
            successor = inorderSuccessor(root.right, p);
        } else {
            successor = inorderSuccessor(root.left, p);
            if (successor == null) successor = root;
        }
        return successor;
    }
}
