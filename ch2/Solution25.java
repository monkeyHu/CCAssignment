package ch2;

public class Solution25 {
	public ListNode SumLists(ListNode l1, ListNode l2) {
		ListNode p = new ListNode(0);
		ListNode head = p;
		int carry = 0;
		/* add two list until either the list arrived the end */
		while (l1 != null && l2 != null) {
			int value = l1.val + l2.val + carry;
			carry = 0;
			if (value >= 10) {
				value = value % 10;
				carry = carry + 1;
			}
			p.next = new ListNode(value);
			p = p.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		/* if the length of l1 is more than the length of l2 */
		while (l1 != null) {
			p.next = new ListNode(l1.val);
			p = p.next;
			l1 = l1.next;
		}

		/* if the length of l2 is more than the length of l1 */
		while (l2 != null) {
			p.next = new ListNode(l2.val);
			p = p.next;
			l2 = l2.next;
		}

		p.next = null;

		return head.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution25 t = new Solution25();
		ListNode l1 = new ListNode(7);
		ListNode p = new ListNode(1);
		ListNode q = new ListNode(6);
		l1.next = p;
		p.next = q;
		q.next = null;
		ListNode l2 = new ListNode(5);
	    ListNode p1 = new ListNode(9);
	    ListNode p2 = new ListNode(2);
	    ListNode p3 = new ListNode(8);
	    l2.next = p1;
	    p1.next = p2;
	    p2.next = p3;
        p3.next = null;
        
	    ListNode head = t.SumLists(l1, l2);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}

}
