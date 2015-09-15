package ch2;

public class Solution28 {
	public ListNode LoopDetection(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		/* check if there is collision node */
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (slow == fast)
				break;
		}

		/* if there are no collision node, return null */
		if (fast.next == null || fast.next.next == null)
			return null;

		/* find the beginning of the loop */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
