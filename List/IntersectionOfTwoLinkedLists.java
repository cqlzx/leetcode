package list;

public class IntersectionOfTwoLinkedLists {

	//Solution 1, change the pointer, second iteration will counteract the difference
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;
		
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		
		return a;
	}
	
	//Solution 2, get the length of lists
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		int lenA = getLength(headA);
		int lenB = getLength(headB);
		
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenB > lenA) {
			headB = headB.next;
			lenB--;
		}
		
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		
		return headA;
	}
	private int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
}
