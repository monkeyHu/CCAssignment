package ch4;

import java.util.HashMap;

/*Given a binary tree,Count the number of paths that sum to a given value*/
public class Solution4_12 {
	int countPathWithSum(TreeNode root, int targetSum){
		if(root == null) return 0;
		HashMap<Integer,Integer> pathCount = new HashMap<Integer,Integer>();
		incrementHashTable(pathCount,0,1);
		return countPathWithSum(root,targetSum,0,pathCount);
	}
	
	int countPathWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer,Integer> pathCount){
		if(node == null) return 0;
		
		runningSum += node.value;
		incrementHashTable(pathCount,runningSum,1);
		
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;
		
		totalPaths += countPathWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathWithSum(node.right,targetSum, runningSum, pathCount);
		
		incrementHashTable(pathCount,runningSum,-1);
		return totalPaths;
	}
	
	void incrementHashTable(HashMap<Integer,Integer> hashTable, int key, int delta){
		if(!hashTable.containsKey(key)){
			hashTable.put(key, 0);
		}
		hashTable.put(key, hashTable.get(key) + delta);
	}
}
