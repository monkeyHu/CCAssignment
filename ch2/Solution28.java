package ch2;

public class Solution28 {
	public ListNode LoopDetection(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		/* check if there is collision node */
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
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
		Solution28 t = new Solution28();
		ListNode l1 = new ListNode(7);
		ListNode p = new ListNode(1);
		ListNode q = new ListNode(6);
		ListNode a = new ListNode(11);
		ListNode l2 = new ListNode(5);
		ListNode p1 = new ListNode(9);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(8);
		l1.next = p;
		p.next = q;
		q.next = l2;
		l2.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = a;
		a.next = q;// Circle Start at Node q
		ListNode loopStart = t.LoopDetection(l1);
		if (loopStart != null) {
			System.out.println(loopStart.val);
		}
	}

}
