package list;

public class RotateList {

	public static void main(String[] args) {
		ListNode head = null;
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		
		head = rotateRight(head, 2);
		
		while(head != null){
			System.out.println(head.val + "->");
			head = head.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int k){
		if(head == null) return null;
		int len = 0;
		ListNode p = head;
		while(p != null){
			len++;
			p = p.next;
		}
		
		k = k % len;
		if(k == 0){
			return head;
		}
		
		int position = len - k;
		p = head;
		for(int i = 1; i < position; i++){
			p = p.next;
		}
		ListNode q = p.next;
		p.next = null;
		p = q;
		for(int i = 1; i < k; i++){
			q = q.next;
		}
		q.next = head;
		head = p;
		
		return head;
	}
}
