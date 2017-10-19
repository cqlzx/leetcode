package math;

import java.util.*;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        boolean[] visited = new boolean[maxChoosableInteger + 1];
        Map<Integer, Boolean> map = new HashMap<>();
        return canIWin(desiredTotal, 0, visited, map);
    }
    
    private boolean canIWin(int target, int current, boolean[] visited, Map<Integer, Boolean> map) {
        int state = convertFromBoolean(visited);
        if (map.containsKey(state)) return map.get(state);
        for (int i = visited.length - 1; i >= 1; i--) {
            if (!visited[i]) {
                visited[i] = true;
                if (target - current <= i || !canIWin(target, current + i, visited, map)) {
                    visited[i] = false;
                    map.put(state, true);
                    return true;
                }
                visited[i] = false;
            }
        }
        map.put(state, false);
        return false;
    }
    
    private int convertFromBoolean(boolean[] visited) {
        int res = 0;
        for (boolean b : visited) {
            res <<= 1;
            if (b) res |= 1;
        }
        return res;
    }
}
