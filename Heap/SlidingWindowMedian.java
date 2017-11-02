package heap;

import java.util.*;

public class SlidingWindowMedian {

	public static void main(String[] args) {
		new SlidingWindowMedian().medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3);

	}

	public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(new Comparator<Long>(){
            @Override
            public int compare(Long a, Long b) {
                if (a > b) return -1;
                else if (a == b) return 0;
                else return 1;
            }
        });
        
        int n = nums.length;
        double[] res = new double[n - k + 1];      
        for (int i = 0; i < n; i++) {
            maxHeap.offer((long) nums[i]);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
            
            if (i < k - 1) continue;
            
            if (k % 2 == 1) {
                res[i - k + 1] = minHeap.peek();
            } else {
                res[i - k + 1] = 0.5 * maxHeap.peek() + 0.5 * minHeap.peek();
            }
            
            int last = nums[i - k + 1];
            if (minHeap.peek() <= last) {
                minHeap.remove(last);
            } else {
                maxHeap.remove(last);
            }
        }
        return res;
    }
}
