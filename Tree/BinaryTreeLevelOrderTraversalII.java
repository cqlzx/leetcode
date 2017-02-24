package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		List<Integer> each = new ArrayList<>();
		boolean next = false;
		while(!q.isEmpty()){
			TreeNode cur = q.poll();
			if(cur == null){
				res.add(0, each);
				each = new ArrayList<>();
				next = true;
				continue;
			}
			
			each.add(cur.val);
			
			if(next){
				q.offer(null);
				next = false;
			}				
			if(cur.left != null) q.offer(cur.left);
			if(cur.right != null) q.offer(cur.right);
		}
		
		return res;
	}
}
