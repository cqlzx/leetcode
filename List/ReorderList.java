package list;

import java.util.*;
public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		reorderList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	
	//Solution 1, in place
	public static void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        
        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }
        
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }
        
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
	}
	
	
	
	//Solution 2, not in place
	public static void reorderList2(ListNode head) {
		Deque<ListNode> front = new LinkedList<>();
		Deque<ListNode> back = new LinkedList<>();
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode p = head, q = slow;
		while (q!= null) {
			front.offer(p);
			back.offer(q);
			p = p.next;
			q = q.next;
		}
		
		ListNode cur = new ListNode(0);
		while (!front.isEmpty()) {
			ListNode former = front.pollFirst();
			cur.next = former;
			ListNode latter = back.pollLast();
			former.next = latter;
			cur = latter;
		}
		
		if (!back.isEmpty()) {
			cur.next = back.pollLast();
			cur = cur.next;
		}
		cur.next = null;
	}
}
