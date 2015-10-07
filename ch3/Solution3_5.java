package ch3;

import java.util.Stack;

/*Implement a stack in which the smallest items are on the top*/
public class Solution3_5 {
	public Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> sortedStack = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
				s.push(sortedStack.pop());
			}
			if (sortedStack.isEmpty() || temp > sortedStack.peek()) {
				sortedStack.push(temp);
			}
		}

		return sortedStack;
	}
}
