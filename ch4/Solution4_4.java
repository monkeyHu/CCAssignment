package ch4;

/*Check Balanced: Implement a function to check if a binary tree is balanced.
 * A balanced tree is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than on
 */
public class Solution4_4 {
	int checkHeight(TreeNode root){
		if(root == null)
			return 0;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1)
			return -1;
		
		int rightHeight = checkHeight(root.right);
		if(leftHeight == -1)
			return -1;
		
		int diff = Math.abs(leftHeight - rightHeight);
		if(diff > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	boolean isBalance(TreeNode root){
		if(checkHeight(root)==-1)
			return false;
		else
			return true;
	}
}
