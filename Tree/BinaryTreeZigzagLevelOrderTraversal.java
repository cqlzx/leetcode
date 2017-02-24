package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> left = new Stack<>();
		Stack<TreeNode> right = new Stack<>();
		right.push(root);
		while(!left.isEmpty() || !right.isEmpty()){
			List<Integer> one = new ArrayList<>();
			while(!right.isEmpty()){
				TreeNode rNode = right.pop();
				one.add(rNode.val);
				if(rNode.left != null) left.push(rNode.left);
				if(rNode.right != null) left.push(rNode.right);
				
			}
			if(one.size() != 0) res.add(one);
			one = new ArrayList<>();
			while(!left.isEmpty()){
				TreeNode lNode = left.pop();
				one.add(lNode.val);
				if(lNode.right != null) right.push(lNode.right);
				if(lNode.left != null) right.push(lNode.left);
			}
			if(one.size() != 0) res.add(one);
		}
		
		return res;
	}
}
