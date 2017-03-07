package list;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		
		head = reverseBetween(head, 2, 3);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n){
		if(m == n) return head;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode p = fakeHead;
		
		for(int i = 0; i < m - 1; i++){
			p = p.next;
		}
		
		ListNode leftEnd = p;
		p = p.next;
		ListNode midEnd = p;
		
		ListNode mid = p.next;
		ListNode q = mid.next;
		
		for(int i = m; i < n; i++){
			mid.next = p;
			p = mid;
			mid = q;
			if(q != null) q = q.next;
		}
		
		midEnd.next = mid;
		leftEnd.next = p;
		
		return fakeHead.next;
	}
}
