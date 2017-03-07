package list;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		
		head = deleteDuplicates(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	//1->1->1->2->3
	//1->2->3->3->4->4->5
	public static ListNode deleteDuplicates(ListNode head){
		ListNode p = head;
		ListNode q = p;
		boolean first = true;
		//check the current node if p = p.next is put at the end of the loop
		//check the next node if p = p.next is put at the start of the loop
		while(p != null){
			boolean dup = false;
			while(p.next != null && p.next.val == p.val){
				p = p.next;
				dup = true;
			}
			if(dup){
				if(first){
					head = p.next;
					q = p.next;
				}else{
					q.next = p.next;	
				}
			}else{
				q = p;
				first = false;
			}
			p = p.next;
		}
		
		return head;
	}
}
