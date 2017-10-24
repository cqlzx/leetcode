package bfs;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return new ArrayList<>();
        
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        dict.remove(beginWord);
        if (!dict.contains(endWord)) return res;
        
        Map<String, Set<String>> preList = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean found = false;
        while (!queue.isEmpty()) {
            Set<String> newQueue = new HashSet<>();
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    found = true;
                    break;
                }
                Set<String> neighbors = getNeighbors(cur, dict, preList);
                newQueue.addAll(neighbors);
            }
            
            if (found) {
                dfs(beginWord, endWord, res, new LinkedList<>(), preList);
                break;
            }
            
            dict.removeAll(newQueue);
            queue.addAll(newQueue);
        }
        
        return res;
    }
    
    private void dfs(String start, String end, List<List<String>> res, LinkedList<String> items, Map<String, Set<String>> map) {
        if (start.equals(end)) {
            items.addFirst(end);
            res.add(new ArrayList<>(items));
            items.remove(0);
            return;
        }

        items.addFirst(end);
        for (String word : map.get(end)) {
            dfs(start, word, res, items, map);
        }
        items.remove(0);
    }
    
    private Set<String> getNeighbors(String s, Set<String> dict, Map<String, Set<String>> map) {
        Set<String> res = new HashSet<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char tmp = cs[i];
            for (char c = 'a'; c < 'z'; c++) {
                if (c == tmp) continue;
                cs[i] = c;
                String newStr = new String(cs);
                if (dict.contains(newStr)) {
                    res.add(newStr);
                    if (!map.containsKey(newStr)) {
                        map.put(newStr, new HashSet<>());
                    }
                    map.get(newStr).add(s);
                }
            }
            cs[i] = tmp;
        }
        return res;
    }
}
