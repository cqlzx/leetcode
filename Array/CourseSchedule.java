package array;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		boolean res = canFinish(5, new int[][]{{1,0},{3,4},{4,2},{2,0},{1,2}});
		System.out.println(res);
	}

	//Solution 1, BFS
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] preTotal = new int[numCourses];
		
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int pre = prerequisites[i][1];
			matrix[pre][course] = 1;
			preTotal[course]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (preTotal[i] == 0) {
				q.offer(i);
			}
		}
		
		int count = 0;
		while (!q.isEmpty()) {
			count++;
			int course = q.poll();
			for (int j = 0; j < numCourses; j++) {
				if (matrix[course][j] == 1) {
					if (--preTotal[j] == 0) {
						q.offer(j);
					}
				}
			}
		}
		
		return count == numCourses;
	}
}
