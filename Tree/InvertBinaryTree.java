package tree;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root){
		if(root == null){
			return null;
		}
		
		TreeNode x = root;
		
		if(x.left == null && x.right != null){
			x.left = x.right;
			x.right = null;
			invertTree(x.left);
		}else if(x.right == null && x.left != null){
			x.right = x.left;
			x.left = null;
			invertTree(x.right);
		}else if(x.left == null && x.right == null){
			return x;
		}else{
			invertTree(x.left);
			invertTree(x.right);
			
			TreeNode temp = x.left;
			x.left = x.right;
			x.right = temp;
		}

		return x;
	}
}
