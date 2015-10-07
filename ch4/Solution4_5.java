package ch4;

/*Check if a binary tree is a binary search tree*/
/*A binary search tree is a tree which left <= current < right*/
public class Solution4_5 {
	public boolean checkBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		/*If value of root is less than the minumum, or the value of is larger than the max*/
		if ((root.value <= min) || ( root.value >= max))
			return false;
		/*Recursively check the left subtree and right subtree*/
		return checkBST(root.left, min, root.value) && checkBST(root.right, root.value, max);
	}

	public boolean isValidBST(TreeNode root) {
		return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4_2 t = new Solution4_2();
		int array[] = { 1, 2, 3, 4, 6, 7, 8 };
		TreeNode root = t.createMinimalBST(array);
		Solution4_5 test = new Solution4_5();
		System.out.println(test.isValidBST(root));
	}
}
