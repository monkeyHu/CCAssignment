package ch3;

import java.util.Stack;

/*Implement a queue using two stacks*/
public class Solution3_4 {
	public class MyQueue<T> {
		// new Stack used to add element and oldStack used to remove the element
		Stack<T> newStack, oldStack;

		public MyQueue() {
			newStack = new Stack<T>();
			oldStack = new Stack<T>();
		}

		public int size() {
			return newStack.size() + oldStack.size();
		}

		public void add(T value) {
			newStack.push(value);
		}

		public T remove() {
			shiftStacks();
			return oldStack.pop();
		}

		public T peek() {
			shiftStacks();//Ensure old stack has the current elements
			return oldStack.peek();
		}

		/*Move elements from new stack to the old stack*/
		public void shiftStacks() {
			if (oldStack.isEmpty()) {
				while (!newStack.isEmpty()) {
					oldStack.push(newStack.pop());
				}
			}
		}
	}
	public static void main(String[] args){
		Solution3_4 t = new Solution3_4();
		MyQueue<Integer> q = t.new MyQueue<Integer>();
	    q.add(5);
	    q.add(8);
	    q.add(9);
	    System.out.println("the first of the queue is: " + q.remove());
	}
}
