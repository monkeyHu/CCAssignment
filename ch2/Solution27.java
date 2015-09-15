package ch2;

public class Solution27 {
	public ListNode findIntersection(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return null;
		TailAndSize ts1 = getTailAndSize(l1);
		TailAndSize ts2 = getTailAndSize(l2);
		if (ts1.tail != ts2.tail) // there is no intersection for 1l and l2
			return null;
		ListNode shortList = ts1.size < ts2.size ? l1 : l2;
		ListNode longList = ts1.size < ts2.size ? l2 : l1;
		int difference = Math.abs(ts1.size - ts2.size);
		while (difference > 0) { // advance the longer linked list
			longList = longList.next;
			difference--;
		}
		while (shortList != longList) {
			shortList = shortList.next;
			longList = longList.next;
		}
		return shortList;
	}

	// save the size and tail of a linked list
	class TailAndSize {
		public ListNode tail;
		public int size;

		public TailAndSize(ListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	// get the tail and size of a linked list
	public TailAndSize getTailAndSize(ListNode head) {
		int length = 1;
		while (head.next != null) {
			length++;
			head = head.next;
		}
		TailAndSize result = new TailAndSize(head, length);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution27 t = new Solution27();
		ListNode l1 = new ListNode(7);
		ListNode p = new ListNode(1);
		ListNode q = new ListNode(6);
		ListNode set = new ListNode(10);
		ListNode a = new ListNode(11);
		l1.next = p;
		p.next = q;
		q.next = set;
		ListNode l2 = new ListNode(5);
		ListNode p1 = new ListNode(9);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(8);
		l2.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = set;
        set.next = a;
        a.next = null;
		ListNode intersection = t.findIntersection(l1, l2);
		if(intersection != null) {
			System.out.println(intersection.val);
		}

	}

}
