package other;

import java.util.*;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
	}
	
	
    Map<Integer, Integer> priority = new HashMap<>();
    Map<Integer, Integer> data = new HashMap<>();
    int size;
    int capacity;
    int sequence;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.sequence = 0;
    }
    
    public int get(int key) {
        if (data.containsKey(key)) {
            int value = data.get(key);
            priority.put(key, sequence++);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (!priority.containsKey(key)){
            if (size == capacity){
                int minValue = Integer.MAX_VALUE;
                int oldKey = 0;
                for (Map.Entry<Integer, Integer> entry : priority.entrySet()) {
                    if (entry.getValue() < minValue) {
                    	minValue = entry.getValue();
                        oldKey = entry.getKey();
                    }
                }
                data.remove(oldKey);
                priority.remove(oldKey);
            } else {
                size++;
            }
        }
        data.put(key, value);
        priority.put(key, sequence++);
    }
}
