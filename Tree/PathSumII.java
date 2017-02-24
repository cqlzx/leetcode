package tree;

import java.util.*;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		helper(root, sum, res, one);
		return res;
	}
	
	public static void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> one){
		if(root == null) return;
		if(root.left == null && root.right == null && root.val == sum){
			one.add(root.val);
			List<Integer> tmp = new ArrayList<>(one);
			one.remove(one.size() - 1);
			res.add(tmp);
			return;
		}
		one.add(root.val);
		helper(root.left, sum - root.val, res, one);
		helper(root.right, sum - root.val, res, one);
		one.remove(one.size() - 1);
	}
}
