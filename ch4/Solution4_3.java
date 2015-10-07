package ch4;

import java.util.ArrayList;
import java.util.LinkedList;

/*Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth
 * (e.g., if you have a tree with depth D, you will have D linked lists).
 */
public class Solution4_3 {
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedLists(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null){
			current.add(root);
		}
		while(current.size() > 0){
			result.add(current);//Add the first level to the result
			LinkedList<TreeNode> parents = current;//go to the next level
			current = new LinkedList<TreeNode>();//Reset the current leverl
			for(TreeNode p:parents){
				if(p.left != null)//If left child is not null
					current.add(p.left);
				if(p.right != null)//If right child is not null
					current.add(p.right);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4_2 t = new Solution4_2();
		int array[] = { 1, 2, 3, 4, 6, 7, 8 };
		TreeNode root = t.createMinimalBST(array);
		Solution4_3 test = new Solution4_3();
		ArrayList<LinkedList<TreeNode>> result = test.createLevelLinkedLists(root);
		for(LinkedList<TreeNode> list:result){
			for(TreeNode node:list){
				System.out.print(node.value + " ");
			}
			System.out.println();
		}

	}
}
