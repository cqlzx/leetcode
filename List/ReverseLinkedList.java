package list;

public class ReverseLinkedList {
	public static void main(String args[]){
		ListNode n = null;
		reverseList(n);
	}
	public static ListNode reverseList(ListNode head){
		ListNode former = head;
		if(former == null) return null;
		if(former.next == null) return former;
		ListNode latter = former.next;
		former.next = null;
		
		while(latter.next != null){
			ListNode p = latter.next;
			latter.next = former;
			former = latter;
			latter = p;
		}
		latter.next = former;
		
		return latter;
	}
}
