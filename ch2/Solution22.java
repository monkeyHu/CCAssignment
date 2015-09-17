package ch2;

public class Solution22 {
	public ListNode kthToLast(ListNode head, int k) {/*use two nodes to traverse the linked list*/
		ListNode slow = head;
		ListNode fast = head;
		int count = 0;
		while (count < k) { //move fast node k steps
			if(fast == null)
				return null;
			fast = fast.next;
			count++;
		}
		while (fast.next != null) { // if fast node arrived at the tail, then slow node is at the length-k node
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Solution22 t = new Solution22();
		ListNode head = new ListNode(1);
		ListNode p = new ListNode(2);
		ListNode q = new ListNode(3);
		head.next = p;
		p.next = q;
		q.next = null;
		ListNode result = t.kthToLast(head, 2);
		System.out.println(result.val);

	}

}
