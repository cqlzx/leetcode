package tenthContest;

import java.util.HashMap;
import java.util.Map;

public class PathSumIIIConcise {
	int ans = 0;
	Map<Integer, Integer> dfs(TreeNode root, int sum){
		if(root == null){
			return new HashMap<>();
		}
		
		Map<Integer, Integer> left = dfs(root.left, sum);
		Map<Integer, Integer> right = dfs(root.right, sum);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(root.val, 1);
		for(Map.Entry<Integer, Integer> entry : left.entrySet()){
			int val = entry.getKey() + root.val;
			int times = entry.getValue();
			map.putIfAbsent(val, 0);
			map.put(val, times + map.get(val));
		}
		
		for(Map.Entry<Integer, Integer> entry : right.entrySet()){
			int val = entry.getKey() + root.val;
			int times = entry.getValue();
			map.putIfAbsent(val, 0);
			map.put(val, times + map.get(val));
		}
		
		ans += map.getOrDefault(sum, 0);
		
		return map;
	}
	
	public int pathSum(TreeNode root, int sum){
		ans = 0;
		dfs(root, sum);
		return ans;
	}
	
}