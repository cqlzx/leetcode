package list;

public class LinkedListCycleII {

	//Solution 1, tricky solution, it's like a math problem.
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) break;
		}
		
		if (fast == null || fast.next == null) return null;
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
}
