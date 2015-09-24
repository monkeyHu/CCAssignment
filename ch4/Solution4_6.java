package ch4;

/*find the next node (i.e. in-orde successor) of a given node in a binary search tree*/
/*if the node has right subtree, then the successor is the left most node of the right subtree
 * if the node dose not have a subtree, if the node is the left children of its a parent, then the parent if the succrssor
 * else we should find upforward until the node is not the right children of its parents
 */
public class Solution4_6 {
	TreeNode inOrderSuccessor(TreeNode node){
		if(node == null)
			return null;
		if(node.right != null){
			TreeNode n = node.right;
			while(n.left != null){
				n = n.left;
			}
			return n;
		}
		else{
			TreeNode q = node;
			TreeNode x = q.parent;
			while(x != null && x.left != q){
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
}
