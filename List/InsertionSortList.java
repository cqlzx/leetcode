package list;

public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if (head == null) return null;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode curPre = head;
		ListNode cur = head.next;
		while (cur != null) {
			ListNode p = fakeHead;
			while (cur.val > p.next.val) {
				p = p.next;
			}
			
			ListNode tmp = cur.next;
			if (p.next != cur){
				cur.next = p.next;
				p.next = cur;
				curPre.next = tmp;
				cur = tmp;
			}else{
				curPre = cur;
				cur = tmp;
			}
		}
		
		return fakeHead.next;
	}
}
