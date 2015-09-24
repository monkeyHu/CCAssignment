package ch4;

import java.util.Random;

/*Implement a binary calss which can insert,find,delete and has methos getRandomNode() which returns a randon node 
 * from the tree
 */
public class Solution4_11 {
	public class TreeNode {
		private int data;
		public TreeNode left;
		public TreeNode right;
		private int size = 0;

		public TreeNode(int d) {
			this.data = d;
			this.size = 1;
		}

		public void insertInorder(int d) {
			if (d <= data) {
				if (left == null)
					left = new TreeNode(d);
				else
					left.insertInorder(d);
			} else {
				if (right == null)
					right = new TreeNode(d);
				else
					right.insertInorder(d);
			}
			this.size++;
		}

		public TreeNode find(int d) {
			if (d == this.data) {
				return this;
			} else if (d <= data) {
				return left != null ? left.find(d) : null;
			} else if (d > data) {
				return right != null ? right.find(d) : null;
			}
			return null;
		}

		public int size() {
			return this.size;
		}

		public int data() {
			return this.data;
		}

		public TreeNode getRandomNode() {
			int leftSize = left == null ? 0 : left.size();
			Random random = new Random();
			int index = random.nextInt(size);
			if (index < leftSize) {
				return left.getRandomNode();
			} else if (index == leftSize) {
				return this;
			} else {
				return right.getRandomNode();
			}
		}
	}

}
