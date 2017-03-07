package list;

import java.util.*;

public class LinkedListCycle {

	//Solution 1, smart solution
	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode walker = fakeHead, runner = head;
		while (walker != null && runner != null && runner.next != null) {
			if (walker == runner) return true;
			walker = walker.next;
			runner = runner.next.next;
		}
		return false;
	}
	
	
	//Solution 2, using hash to check if the list has cycle
	public boolean hasCycle2(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			set.add(head);
			if (set.contains(head.next)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}
}
