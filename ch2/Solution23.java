package ch2;

public class Solution23 {
	public void deleteMiddleNode(ListNode del) {
		del.val = del.next.val; // save the next node's value to this node
		del.next = del.next.next; // just delete next node
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution23 t = new Solution23();
		ListNode head = new ListNode(1);
		ListNode p = new ListNode(2);
		ListNode q = new ListNode(3);
		head.next = p;
		p.next = q;
		q.next = null;
	    t.deleteMiddleNode(p);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}