package tree;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public static TreeNode buildTree(int[] inorder, int[] postorder){
		return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd){
		if(iStart > iEnd || pStart > pEnd) return null;
		int num = postorder[pEnd];
		TreeNode cur = new TreeNode(num);
		int count = 0;
		for(int i = iEnd; i >= iStart; i--){
			if(inorder[i] == num) break;
			count++;
		}
		cur.right = buildTree(inorder, postorder, iEnd - count + 1, iEnd, pEnd - count, pEnd - 1);
		cur.left = buildTree(inorder, postorder, iStart, iEnd - count - 1, pStart, pEnd - count - 1);
		
		return cur;
	}
}
