package ch4;

/*Check Balanced: Implement a function to check if a binary tree is balanced.
 * A balanced tree is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than on
 */
public class Solution4_4 {
	// Class used to store the height of the subtree and whether the subtree is
	// balanced
	class result {
		int height;
		boolean isBalanced;

		result(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

	public result height(TreeNode node) {
		// If node equals to null, return height is 0 and isBalanced is true
		if (node == null)
			return new result(0, true);
		// Obtain the height of the left subtree
		result left = height(node.left);
		// Obtain the height of the right subtree
		result right = height(node.right);
		// Initialized a result
		result ret = new result(0, false);
		// The height is the max of subtree's height plus 1
		ret.height = Math.max(left.height, right.height) + 1;
		// Check if the difference of subtree's height is less than 1
		boolean diff = Math.abs(left.height - right.height) > 1 ? false : true;
		// If left subtree is balanced, right subtree is balanced and the
		// difference is less than 1, then the tree is balanced
		ret.isBalanced = left.isBalanced && right.isBalanced && diff;
		return ret;
	}

	public boolean isBalanced(TreeNode root) {
		return height(root).isBalanced;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4_2 t = new Solution4_2();
		int array[] = { 1, 2, 3, 4, 6, 7, 8 };
		TreeNode root = t.createMinimalBST(array);
		Solution4_4 test = new Solution4_4();
		System.out.println(test.isBalanced(root));

	}
}
