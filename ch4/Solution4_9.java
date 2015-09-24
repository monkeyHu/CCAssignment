package ch4;

import java.util.ArrayList;
import java.util.LinkedList;

/*Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree*/
public class Solution4_9 {
	public ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if(node == null){
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.value);
		
		/*Recurse on left and right subtrees*/
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		for(LinkedList<Integer> left:leftSeq){
			for(LinkedList<Integer> right:rightSeq){
				ArrayList<LinkedList<Integer>>weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left,right,weaved,prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}
	
	void weaveLists(LinkedList<Integer> first, LinkedList<Integer>second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
		if(first.size() == 0 || second.size() == 0){
			@SuppressWarnings("unchecked")
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			result.addAll(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first,second,results,prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first,second,results,prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
		}
	}

