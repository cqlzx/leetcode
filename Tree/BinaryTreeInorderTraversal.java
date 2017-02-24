package tree;

import java.util.*;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> res = inorderTraversal(root);
		System.out.println(res.toString());
	}

	//Solution 1, iterative
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.offer(cur);
				cur = cur.left;
			}
			cur = stack.pollLast();
			res.add(cur.val);
			cur = cur.right;
		}
		
		return res;
	}

	
	//Solution 2, recursive
	public static List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		inorder(root, res);
		return res;
	}
	public static void inorder(TreeNode root, List<Integer> res){
		if(root != null){
			inorder(root.left, res);
			res.add(root.val);
			inorder(root.right, res);
		}
	}
}
