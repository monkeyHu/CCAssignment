package ch4;

/*Given a sorted array with unique integer elements, write an algorithm to create a binary search tree with minimal height*/
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
    TreeNode parent;
	TreeNode(int val) {
		this.value = val;
	}
}

public class Solution4_2 {
	public TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

	/*Since the array is sorted, to obtain a minimal height tree, we should make the number of nodes
	in both subtree is almost equal, so we first choose the middle as the root*/
	public TreeNode createMinimalBST(int array[], int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(array[mid]);//Make the middle as the root
		n.left = createMinimalBST(array, start, mid - 1);//Recursively create the left subtree
		n.right = createMinimalBST(array, mid + 1, end);//Recursively create the right subtree
		return n;
	}

	public void inorderTraverse(TreeNode node) {
		if (node != null) {
			inorderTraverse(node.left);
			System.out.println(node.value);
			inorderTraverse(node.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4_2 t = new Solution4_2();
		int array[] = { 1, 2, 3, 4, 6, 7, 8 };
		TreeNode root = t.createMinimalBST(array);
		t.inorderTraverse(root);

	}
}
