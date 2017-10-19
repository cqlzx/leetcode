package other;

import java.util.*;

public class ZigzagIteratorFollowUp {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(new Integer[]{1,2,3});
		List<Integer> list2 = Arrays.asList(new Integer[]{4,5,6,7});
		List<Integer> list3 = Arrays.asList(new Integer[]{8,9});
		List<List<Integer>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		
		ZigzagIteratorFollowUp zzit = new ZigzagIteratorFollowUp(list);
		while (zzit.hasNext()) {
			System.out.print(zzit.next() + " ");
		}
	}

	
    Queue<Iterator> queue = new LinkedList<>();
    
    public ZigzagIteratorFollowUp(List<List<Integer>> list) {
        for (List<Integer> items : list) {
        	if (items.size() != 0) {
        		queue.offer(items.iterator());
        	}
        }
    }

    public int next() {
        Iterator it = queue.poll();
        int res = (int) it.next();
        if (it.hasNext()) queue.offer(it);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
