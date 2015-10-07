package ch3;

import java.util.Stack;

/*Implement a stack which can return the minimum element in o(1) time
 * A additional stack is used to track the minimum of the stack, if the new added
 * element is smaller than the minimum ,then this element will be added to the minStack,otherwise not
 * if a element which is to be poped from the stack, if the value of it is equals to the top of the minStack
 * then this element will be removed from minStack
 */
public class Solution3_2 {
	@SuppressWarnings("serial")
	public class StackWithMin extends Stack<Integer> {
		private Stack<Integer> minStack; //Stack store minimums

		public StackWithMin() {
			minStack = new Stack<Integer>();
		}

		public int min() {
			if (minStack.isEmpty())
				return Integer.MAX_VALUE;
			else
				return minStack.peek();
		}

		public void push(int value) {
			super.push(value);
			if (value <= min()) { //If the value is less or equal than the minimum, push it into the minStack
				minStack.push(value);
			}
		}

		public Integer pop() {
			int value = super.pop();
			if (value == minStack.peek()) {
				minStack.pop();
			}
			return value;
		}
	}
	public static void main(String[] args){
		Solution3_2 t = new Solution3_2();
		StackWithMin stackMin = t.new StackWithMin();
	    stackMin.push(512);
	    stackMin.push(-1024);
	    stackMin.push(-1024);
	    stackMin.push(512);
	    stackMin.pop();
	    System.out.println(stackMin.min());
	    stackMin.pop();
	    System.out.println(stackMin.min());
	    stackMin.pop();
	    System.out.println(stackMin.min());
	}
}
