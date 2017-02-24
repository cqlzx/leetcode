package tree;

import java.util.*;

public class PopulateNextRightPointersInEachNode {
	
	//Solution 1
	public void connect(TreeLinkNode root){
		if(root == null) return;
		Queue<TreeLinkNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()){
			TreeLinkNode cur = q.poll();
			if(cur == null){
				if(q.isEmpty()) break;
				q.offer(null);
				continue;
			}
			if(cur.left != null) q.offer(cur.left);
			if(cur.right != null) q.offer(cur.right);
			cur.next = q.peek();
		}
	}
	
	
	//Solution 2
	public void connect2(TreeLinkNode root){
		TreeLinkNode level_start = root;
		while(level_start != null){
			TreeLinkNode cur = level_start;
			while(cur != null){
				if(cur.left != null) cur.left.next = cur.right;
				if(cur.right != null && cur.next != null) cur.right.next = cur.next.left;
				
				cur = cur.next;
			}
			level_start = level_start.left;
		}
	}
}
