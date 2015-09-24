package ch3;

/*use a single array to implement three stacks*/

public class Solution3_1 {

	public class MultiStack {
		private int[] buff; //The array
		private int[] ptop; //Record the top of each stack
		private int size; // the size of each stack

		public MultiStack(int size) {
			this.size = size;
			buff = new int[size * 3];
			ptop = new int[3];
			for (int i = 0; i < 2; i++)
				ptop[i] = -1;
		}

		public int[] getBuff() {
			return buff;
		}

		public void setBuff(int[] buff) {
			this.buff = buff;
		}

		public void push(int stackNum, int value) {
			int index = stackNum * size + ptop[stackNum] + 1;
			buff[index] = value;
			ptop[stackNum]++;
		}

		public void pop(int stackNum) {
			ptop[stackNum]--;
		}

		public int top(int stackNum) {
			int index = stackNum * size + ptop[stackNum];
			return buff[index];
		}

		/*check if stackNum th Stack is empty*/
		boolean empty(int stackNum) {
			return ptop[stackNum] == -1;
		}
	}
	
	public static void main(String[] args){
		Solution3_1 t = new Solution3_1();
		MultiStack multiStack = t.new MultiStack(3);
	    multiStack.push(0,1);
	    multiStack.push(0,2);
	    System.out.println("the top the first stack " + multiStack.top(0));
	    multiStack.push(1,3);
	    System.out.println("the top the second stack " + multiStack.top(1));
	}
}
