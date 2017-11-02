package heap;

import java.util.*;

import list.ListNode;

public class MergeKSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for (ListNode head : lists) {
            if (head != null) pq.offer(head);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = new ListNode(node.val);
            cur = cur.next;
            if (node.next != null) pq.offer(node.next);
        }
        
        return dummy.next;
    }
}
