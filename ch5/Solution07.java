package ch5;

/*Swap odd and even bits in an integer with as few instructions as possible*/

public class Solution07 {

	/*Mask all the odd bits with 10101010(0XAA) and then shift them right by 1 to put them in the even spots
	 * and then mask all the even bits with 01010101(0X55) and then shift them left by 1 to put them in the odd spots
	 * Finally merge these two values
	 */
	
	public int swapOddAndEven(int n){
		return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Solution07 t = new Solution07();
        int n = 0xAA;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(t.swapOddAndEven(n)));
	}

}
