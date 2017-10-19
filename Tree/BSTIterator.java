package tree;

import java.util.*;

public class BSTIterator {

	Stack<TreeNode> stack = new Stack<>();
	
    public BSTIterator(TreeNode root) {
    	while (root != null) {
    		stack.push(root);
    		 root = root.left;
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
		TreeNode tmp = stack.pop();
		TreeNode cur = tmp.right;
		while (cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }	
        return tmp.val;
    }
}
