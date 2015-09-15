package ch2;

public class Solution24 {
	public ListNode Partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode p = new ListNode(0);
		p.next = head;
		head = p; // used to save the result head
		ListNode tail = head;

		/* get the tail and length */
		int length = 0;
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}

		while (length > 0) {
			if (p.next.val < x) {
				p = p.next;
				length--;
			} else {
				tail.next = new ListNode(p.next.val);
				tail = tail.next;
				p.next = p.next.next;
				length--;
			}
		}
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution24 t = new Solution24();
		ListNode l2 = new ListNode(5);
		ListNode p1 = new ListNode(9);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(8);
		l2.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = null;

		ListNode head = t.Partition(l2, 7);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}

}
