package list;

public class RemoveLinkedListElements {

	//Solution 1, iteration
	public ListNode removeElements(ListNode head, int val) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			if (pre.next.val == val) pre.next = cur;
			else pre = pre.next;
		}
		return fakeHead.next;
	}
	
	//Solution 2, Recursion
	public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
}
}
