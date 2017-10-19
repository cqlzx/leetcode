package array;

import java.util.*;

public class CourseScheduleII {

	public static void main(String[] args) {
		int[] res = findOrder2(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
		for (int num : res) {
			System.out.println(num);
		}
	}
	
	//Solution 1, bfs, using array, traverse every element, cost more time
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Queue<Integer> q = new LinkedList<>();
		int[] res = new int[numCourses];
		int[][] matrix = new int[numCourses][numCourses];
		int[] depth = new int[numCourses];
		
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int pre = prerequisites[i][1];
			matrix[pre][course] = 1;
			depth[course]++;
		}
		
		for (int i = 0; i < depth.length; i++) {
			if (depth[i] == 0) {
				q.offer(i);
			}
		}
		
		int total = 0;
		while (!q.isEmpty()) {
			int course = q.poll();
			res[total++] = course;
			for (int j = 0; j < numCourses; j++) {
				if (matrix[course][j] == 1) {
					if (--depth[j] == 0){
						q.offer(j);
					}
				}
			}
		}
		
		return total == numCourses ? res : new int[0];
	}
	
	
	//Solution 2, bfs, using list, faster
	public static int[] findOrder2(int numCourses, int[][] prerequisites) {
		Queue<Integer> q = new LinkedList<>();
		List<List<Integer>> ajs = new ArrayList<>();
		int[] res = new int[numCourses];
		int[] depth = new int[numCourses];
		
		for (int i = 0; i < numCourses; i++) ajs.add(new ArrayList<>());
		
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int pre = prerequisites[i][1];
			ajs.get(pre).add(course);
			depth[course]++;
		}
		
		for (int i = 0; i < depth.length; i++) {
			if (depth[i] == 0) {
				q.offer(i);
			}
		}
		
		int total = 0;
		while (!q.isEmpty()) {
			int from = q.poll();
			res[total++] = from;
			for (int to : ajs.get(from)) {
				if (--depth[to] == 0){
					q.offer(to);
				}
			}
		}
		
		return total == numCourses ? res : new int[0];
	}
}
