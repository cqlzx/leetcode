package bfs;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        int dis = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            Queue<String> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return dis;
                char[] cs = cur.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char c = cs[i];
                    for (int k = 0; k < 26; k++) {
                        if (c == k + 'a') continue;
                        cs[i] = (char) (k + 'a');
                        String newStr = new String(cs);
                        if (dict.contains(newStr)) {
                            dict.remove(newStr);
                            newQueue.offer(newStr);
                        }
                    }
                    cs[i] = c;
                }
            }
            queue = newQueue;
            dis++;
        }
        return 0;
    }

}
