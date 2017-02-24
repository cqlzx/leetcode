package tree;

public class ConstructBinaryTreeFromPreorederAndInordeTraversal {
	
	public static TreeNode buildTree(int[] preorder, int[] inorder){
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd){
		if(pStart > pEnd || iStart > iEnd) return null;
		int num = preorder[pStart];
		TreeNode cur = new TreeNode(num);
		int count = 0;
		for(int i = iStart; i <= iEnd; i++){
			if(inorder[i] == num) break;
			count++;
		}
		cur.left = buildTree(preorder, inorder, pStart + 1, pStart + count, iStart, iStart + count - 1);
		cur.right = buildTree(preorder, inorder, pStart + count + 1, pEnd, iStart + count + 1, iEnd);
		
		return cur;
	}
}
