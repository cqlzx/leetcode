package tenthContest;

public class PathSumIII {
	int count = 0;
	
	public int pathSum(TreeNode root, int sum){
//		System.out.println(count);	
		count = 0;		//must declare this. If not, leetcode will initiate it as 3 so the solution can not be accepted.
		scanTree(root, sum);
		return count;
	}
	
	public void scanTree(TreeNode root, int sum){
		if(root != null){
			TreeNode sumTree = new TreeNode(root.val);
			buildSumTree(root, sumTree);
			countSum(sumTree, sum);
			
			scanTree(root.left, sum);
			scanTree(root.right, sum);
		}
	}
	
	public void buildSumTree(TreeNode root, TreeNode sumTree){
		if(root.left != null){
			TreeNode left = new TreeNode(sumTree.val + root.left.val);
			sumTree.left = left;
			buildSumTree(root.left, sumTree.left);
		}
		
		if(root.right != null){
			TreeNode right = new TreeNode(sumTree.val + root.right.val);
			sumTree.right = right;
			buildSumTree(root.right, sumTree.right);
		}
	}
	
	public void countSum(TreeNode root, int target){
		if(root != null){
			if(root.val == target){
				count++;
			}
			
			countSum(root.left, target);
			countSum(root.right, target);
		}
	}

	public static void main(String args[]){
//		TreeNode root = new TreeNode(5);
//		
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(8);
//		
//		root.left.left = new TreeNode(11);
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//		
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(2);
//		root.right.left.left = new TreeNode(5);
//		root.right.left.right = new TreeNode(1);
		
//		int i = pathSum(root, 22);
//		System.out.println(i);
		
		PathSumIII a = new PathSumIII();
		a.pathSum(new TreeNode(1), 8);
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

