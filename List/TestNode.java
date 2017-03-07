package list;

public class TestNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode p = head;
		p = p.next;
		
		p.next = new ListNode(999);
		System.out.println(head.next.next.val);
		
//		p = p.next;
//		System.out.println(p.val);
//		System.out.println(head.val);
	}

}
