package list;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head = deleteDuplicates(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head){
		if(head == null) return null;
		ListNode p = head;
		while(p.next != null){
			if(p.next.val == p.val){
				p.next = p.next.next;
			}else{
				p = p.next;
			}
		}
		
		return head;
	}
}
