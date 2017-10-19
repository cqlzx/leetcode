package array;

import java.util.*;

public class MergeIntervals {
	
    public List<Interval> merge(List<Interval> intervals) {
        Stack<Interval> stack = new Stack<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        for (int i = 0; i < intervals.size(); i++) {
           int currentStart = intervals.get(i).start;
           int currentEnd = intervals.get(i).end;
           if (stack.isEmpty() || stack.peek().end < currentStart) {
               stack.push(intervals.get(i));
               continue;
           }
           
           Interval preInterval = stack.pop();
           while (preInterval.end >= currentStart) {
               if (preInterval.start < currentStart || stack.isEmpty() || stack.peek().end < currentStart) {
                   preInterval.start = Math.min(preInterval.start, currentStart);
                   preInterval.end = currentEnd;
                   break;
               }
               preInterval = stack.pop();
           }
           stack.push(preInterval);
        }
        
        return new ArrayList<Interval>(stack);
    }
    
    //Cleaner and faster
    public List<Interval> merge2(List<Interval> intervals) {
    	if (intervals.size() <= 1) return intervals;
    	
    	List<Interval> res = new ArrayList<>();
    	
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval interval : intervals) {
        	if (interval.start <= end) {
        		end = Math.max(end, interval.end);
        	} else {
        		res.add(new Interval(start, end));
        		start = interval.start;
        		end = interval.end;
        	}
        }
        
        res.add(new Interval(start, end));
        
        return res;
    }
    
    class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
}
