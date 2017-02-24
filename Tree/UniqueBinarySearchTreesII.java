package tree;

import java.util.*;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		List<TreeNode> res = generateTrees(3);
		for(TreeNode t : res){
			System.out.println(t.val);	
		}
	}

	public static List<TreeNode> generateTrees(int n){
		if(n == 0) return new ArrayList<>();
		 return generate(1, n);
	}
	
	public static List<TreeNode> generate(int start, int end){
		List<TreeNode> res = new ArrayList<>();
		if(start > end){
			res.add(null);
			return res;
		}
		
		if(start == end){
			res.add(new TreeNode(start));
			return res;
		}
		
		for(int i = start; i <= end; i++){
			List<TreeNode> left = generate(start, i - 1);
			List<TreeNode> right = generate(i + 1, end);	
			for(TreeNode l : left){
				for(TreeNode r : right){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}				
		}
		
		return res;
	}
}
