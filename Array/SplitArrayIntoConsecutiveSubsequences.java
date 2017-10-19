package array;

import java.util.*;

public class SplitArrayIntoConsecutiveSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = new SplitArrayIntoConsecutiveSubsequences().isPossible(new int[]{1,2,3,3,4,4,5,5});
		System.out.println(res);
	}
	
	public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                int last1 = l1.get(l1.size() - 1), last2 = l2.get(l2.size() - 1);
                if (last1 != last2) return last1 - last2;
                else return l1.size() - l2.size();
            }
        });
        
        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        pq.offer(tmp);
        for (int i = 1; i < nums.length; i++) {
            List<Integer> list = pq.poll();
            int last = list.get(list.size() - 1);
            while (last < nums[i] - 1) {
                if (list.size() < 3) {
                	return false;
                }
                
                if (pq.size() == 0) {
                	break;
                } else {
                	list = pq.poll();
                	last = list.get(list.size() - 1);
                }
            }
            
            if (last == nums[i]) {
                tmp = new ArrayList<>();
                tmp.add(nums[i]);
                pq.offer(tmp);
                pq.offer(list);
            } else if (last == nums[i] - 1) {
                list.add(nums[i]);
                pq.offer(list);
//                System.out.println(list.toString());
            } else {
                tmp = new ArrayList<>();
                tmp.add(nums[i]);
                pq.offer(tmp);
            }
        }
        
        for (List<Integer> list : pq) {
        	System.out.println(2);
            if (list.size() < 3) return false;
        }
        return true;
    }
}
