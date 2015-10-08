package ch5;

/*Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits
 * in their representation
 */
public class Solution04 {
    int getNext(int n){
    	int b = n;
    	int c0 = 0;
    	int c1 = 0;
    	/*Count the trailing zeros*/
    	while((b & 1)==0 && (b != 0)){
    		c0++;
    		b = b >> 1;
    	}
    	/*Count the right most non-trailing zero*/
    	while((b & 1)==1){
    		c1 ++;
    		b = b >> 1;
    	}
    	
    	/*Since the integer is positive, then if n = 11..1100..000, then there is no bigger number with the same
    	 * number of 1s
    	 */
    	if(c0 + c1 == 31){
    		return -1;
    	}
    	
    	int p = c0 + c1;
    	
    	n = n |(1 << p);/*Flip the rightmost non-trailing zero*/
    	n = n & ~((1 << p) -1 ); //Clear all the bits to the right of p
    	n = n | ((1 << (c1 -1))-1);//Insert (c1 - 1) ones on the right
    	
    	return n;
    	
    	}
    
    public int getPrev(int n){
    	int b = n;
    	int c0 = 0;
    	int c1 = 0;
    	/*Get the trailing 1s*/
    	while((b &1)== 1){
    		c1++;
    		b = b >> 1;
    	}
    	
    	if(b ==0)
    		return -1;
    	
    	while((b & 1)==0 && b != 0 ){
    		c0++;
    		b = b >> 1;
    	}
    	
    	int p = c0 + c1;//Get the rightmost trailing 1
    	n = n & ((~0) << (p+1));///Flip the pth bit and clear all the bit to the right of p
    	int mask = (1 << (c1 + 1)) - 1; //Sequence of (c1 + 1) 1s 
    	n = n | mask << (c0 - 1);
    	
    	return n;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Solution04 t = new Solution04();
        int n = 13948;
        System.out.println("n: " + Integer.toBinaryString(n));
        int next = t.getNext(n);
        System.out.println("next: " + Integer.toBinaryString(next));
        int pre = t.getPrev(n);
        System.out.println("pre: " + Integer.toBinaryString(pre));
	}


}
