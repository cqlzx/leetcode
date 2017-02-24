package tree;

import java.util.*;

public class SymmetricTree {

	public static void main(String[] args) {

	}

	//Solution 1, recursive
	public static boolean isSymmetric(TreeNode root){
		if(root == null) return true;
		return isSymmetric(root.left, root.right);
	}
	public static boolean isSymmetric(TreeNode left, TreeNode right){
		if(left == null || right == null) return left == right;
		if(left.val != right.val) return false;
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	
	//Solution 2, iterative
	public static boolean isSymmetric2(TreeNode root){
		if(root == null) return true;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root.left);
		q.offer(root.right);
		while(q.size() != 0){
			TreeNode left = q.poll();
			TreeNode right = q.poll();
			if(left == null || right == null){
				if(left == right){
					continue;
				}else{
					return false;
				}
			}
			
			if(left.val != right.val) return false;
			
			q.offer(left.left);
			q.offer(right.right);
			q.offer(left.right);
			q.offer(right.left);
		}
		
		return true;
	}
}
