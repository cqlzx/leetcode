package list;

import java.util.*;

public class PalindromeLinkedList {

	//Solution 1, using stack, O(n) time and O(n) space
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
        	stack.push(walker);
            walker = walker.next;
            runner = runner.next.next;
        }
        
        if (runner != null) walker = walker.next;
        while (!stack.isEmpty()) {
            if (stack.pop().val != walker.val) return false;
            walker = walker.next;
        }
        
        return true;
	}
	
	//Solution 2, reverse the second half
}
