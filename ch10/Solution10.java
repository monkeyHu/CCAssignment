package ch10;

/*Implement a data structures and algorithms to be able to look up the rank of a number x int a stream of integers*/
public class Solution10 {
	public class RankNode {
		public int left_size = 0;
		public RankNode left, right;
		public int data = 0;

		public RankNode(int d) {
			data = d;
		}

		public void insert(int d) {
			if (d <= data) {
				if (left != null)
					left.insert(d);
				else
					left = new RankNode(d);
				left_size++;
			} else {
				if (right != null)
					right.insert(d);
				else
					right = new RankNode(d);
			}
		}

		public int getRank(int d) {
			if (d == data) {
				return left_size;
			} else if (d < data) {
				if (left == null)
					return -1;
				else
					return left.getRank(d);
			} else {
				int right_rank = right == null ? -1 : right.getRank(d);
				if (right_rank == -1)
					return -1;
				else
					return left_size + 1 + right_rank;
			}
		}
	}

	private RankNode root = null;

	public void track(int number) {
		if (root == null)
			root = new RankNode(number);
		else {
			root.insert(number);
		}
	}

	public int getRankOfNumber(int number) {
		return root.getRank(number);
	}

}
