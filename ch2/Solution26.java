package ch2;

import java.util.Stack;

public class Solution26 {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {// the length of linked list is odd, just pass the middle element
			slow = slow.next;
		}
		while (slow != null) {
			int value = stack.pop();
			if (value != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution26 t = new Solution26();
		ListNode head = new ListNode(1);
		ListNode p = new ListNode(2);
		ListNode q = new ListNode(2);
		ListNode k= new ListNode(1);
		head.next = p;
		p.next = q;
		q.next = k;
		k.next = null;
		boolean result = t.isPalindrome(head);
		System.out.println(result);

	}

}
