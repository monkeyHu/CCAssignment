package ch5;

/*Determine the bits we need to flip to convert Integer A to Integer B
 * As we know the XOR operation can set the different bit to 1 and the same bit to 0, so we can count how many 1s
 * int A XOR B
 */
public class Solution06 {
	public int bitRequired(int a, int b){
		int count = 0;
		for(int c = a ^ b; c != 0; c = c & (c -1)) //c & (c -1 ) can clear the least significant bit
			count++;
		return count;
	}
	public static void main(String[] args) {
		int a = 29;
		int b = 15;
		Solution06 t = new Solution06();
		System.out.println("a: " + Integer.toBinaryString(a));
		System.out.println("b: " + Integer.toBinaryString(b));
		System.out.println("Bit swap required : " + t.bitRequired(a, b));

	}

}
