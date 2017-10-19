package other;

import java.util.*;

public class AllOne {

    LinkedList<Integer> maxToMin;
    Map<String, Integer> keyToValue;
    Map<Integer, LinkedHashSet<String>> valueToKeys;
    
    /** Initialize your data structure here. */
    public AllOne() {
        maxToMin = new LinkedList<>();
        keyToValue = new HashMap<>();
        valueToKeys = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyToValue.containsKey(key)) {
            int val = keyToValue.get(key);
            valueToKeys.get(val).remove(key);
            if (valueToKeys.get(val).size() == 0) {
                valueToKeys.remove(val);
                if (maxToMin.peekLast() == val) {
                    maxToMin.pollLast();
                } else if (maxToMin.peekFirst() == val) {
                    maxToMin.pollFirst();
                }
            }
            
            val += 1;
            keyToValue.put(key, val);
            if (!valueToKeys.containsKey(val)) {
                valueToKeys.put(val, new LinkedHashSet<>());
            }
            valueToKeys.get(val).add(key);
            if (maxToMin.isEmpty() || maxToMin.peekFirst() < val) {
                maxToMin.offerFirst(val);
            }
        } else {
            int val = 1;
            keyToValue.put(key, val);
            if (!valueToKeys.containsKey(val)) {
                valueToKeys.put(val, new LinkedHashSet<>());
            }
            valueToKeys.get(val).add(key);
            if (maxToMin.isEmpty() || maxToMin.peekFirst() < val) {
                maxToMin.offerFirst(val);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyToValue.containsKey(key)) {
            int val = keyToValue.get(key);
            valueToKeys.get(val).remove(key);
            if (valueToKeys.get(val).size() == 0) {
                valueToKeys.remove(val);
                if (maxToMin.peekLast() == val) {
                    maxToMin.pollLast();
                } else if (maxToMin.peekFirst() == val) {
                    maxToMin.pollFirst();
                }
            }
            
            if (val == 1) return;
            
            val -= 1;
            keyToValue.put(key, val);
            if (!valueToKeys.containsKey(val)) {
                valueToKeys.put(val, new LinkedHashSet<>());
            }
            valueToKeys.get(val).add(key);
            if (maxToMin.isEmpty() || maxToMin.peekLast() > val) {
                maxToMin.offerLast(val);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (maxToMin.size() == 0) return "";
        int val = maxToMin.peekFirst();
        return valueToKeys.get(val).iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (maxToMin.size() == 0) return "";
        int val = maxToMin.peekLast();
        return valueToKeys.get(val).iterator().next();
    }
    
    
    
    
    
    
    public static void main(String[] args) {
    	AllOne test = new AllOne();
    	test.inc("a");
    	test.inc("b");
    	test.inc("b");
    	test.inc("c");
    	test.inc("c");
    	test.inc("c");
    	test.dec("b");
    	test.dec("b");
    	System.out.println(test.getMinKey());
    	test.dec("a");
    	System.out.println(test.getMaxKey());
//    	System.out.println(test.getMaxKey());
//    	System.out.println(test.maxToMin.toString());
    	System.out.println(test.getMinKey());
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
