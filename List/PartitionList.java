package list;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(6);
		
		head = partition(head, 5);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	//It's convenient to create the fake head 
	//1->4->3->2->5->2
	//1->2->2->4->3->5
	public static ListNode partition(ListNode head, int x){
		ListNode leftHead = new ListNode(0);
		ListNode p = leftHead;
		ListNode rightHead = new ListNode(0);
		ListNode q = rightHead;
		
		ListNode m = head;
		while(m != null){
			if(m.val < x){
				p.next = m;
				p = p.next;
			}else{
				q.next = m;
				q = q.next;
			}
			m = m.next;
		}
		p.next = rightHead.next;
		q.next = null;
		
		return leftHead.next;
	}
}
