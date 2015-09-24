package ch4;

/*Check if a binary tree is a binary search tree*/
public class Solution4_5 {
	public boolean checkBST(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;
		if ((min != null && root.value <= min) || (max != null && root.value >= max))
			return false;
		return checkBST(root.left, min, root.value) && checkBST(root.right, root.value, max);
	}

	public boolean isValidBST(TreeNode root) {
		return checkBST(root, null, null);
	}
}
