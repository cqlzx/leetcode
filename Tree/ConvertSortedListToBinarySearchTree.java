package tree;

import list.ListNode;

public class ConvertSortedListToBinarySearchTree {

	public static TreeNode sortedListToBST(ListNode head){
		if(head == null) return null;
		if(head.next == null) return new TreeNode(head.val);
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = null;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		pre.next = null;
		TreeNode cur = new TreeNode(slow.val);
		cur.left = sortedListToBST(head);
		cur.right = sortedListToBST(mid);
		
		return cur;
	}
}
