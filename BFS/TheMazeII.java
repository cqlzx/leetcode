package bfs;

import java.util.*;

public class TheMazeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return -1;
        int m = maze.length, n = maze[0].length;
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(start[0], start[1]));
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] minDistance = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(minDistance[i], Integer.MAX_VALUE);
        minDistance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] d : dir) {
                int dis = 0;
                int row = cur.i, col = cur.j;
                while (row + d[0] >= 0 && row + d[0] < m && col + d[1] >= 0 && col + d[1] < n && maze[row + d[0]][col + d[1]] == 0) {
                    row += d[0];
                    col += d[1];
                    dis++;
                }
                
                int tmp = minDistance[cur.i][cur.j];
                if (tmp + dis < minDistance[row][col]) {
                    minDistance[row][col] = tmp + dis;
                    queue.offer(new Cell(row, col));
                }
            }
        }
        int res = minDistance[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    class Cell {
        int i;
        int j;
        public Cell(int i_, int j_) {
            i = i_;
            j = j_;
        }
    }
}
