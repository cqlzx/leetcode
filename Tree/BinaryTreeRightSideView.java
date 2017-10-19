package tree;

import java.util.*;

public class BinaryTreeRightSideView {
	
	//Solution 1, Recursively view right side
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }   
    private void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
    
    //Solution 2, Level traversal and pick the most right node.
	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		int pre = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				res.add(pre);
				if (!queue.isEmpty()) queue.offer(null);
				continue;
			}
			if (cur.left != null) queue.offer(cur.left);
			if (cur.right != null) queue.offer(cur.right);
			pre = cur.val;
		}
		return res;
	}
}
