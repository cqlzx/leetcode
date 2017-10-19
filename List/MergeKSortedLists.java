package list;

import java.util.*;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(-2);
		node1.next = new ListNode(-1);
		node1.next.next = new ListNode(-1);
		node1.next.next.next = new ListNode(-1);
		ListNode node2 = null;
		ListNode[] lists = new ListNode[2];
		lists[0] = node1;
		lists[1] = node2;
		ListNode res = new MergeKSortedLists().mergeKLists(lists);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (ListNode node : lists) {
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
			cur.next = pq.poll();
            cur = cur.next;
//            System.out.println(cur.val);
        }
        cur.next = null;
        return dummy.next;
    }
}
