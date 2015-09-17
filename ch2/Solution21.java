package ch2;

public class Solution21 {
	public ListNode removeDup(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		while (p.next != null) {
			if (p.next.val == p.val) { /* if the value of next node is equal to the next next node,
			                              remove the next node*/
				p.next = p.next.next;
			}
			if (p.next == null)
				break;
			p = p.next;
		}
		return head;

		
	}

	public static void main(String[] args) {
		Solution21 t = new Solution21();
		ListNode head = new ListNode(1);
		ListNode p = new ListNode(1);
		ListNode q = new ListNode(3);
		head.next = p;
		p.next = q;
		q.next = null;
		head = t.removeDup(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
