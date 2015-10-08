package ch5;

public class Solution01 {
	//Clear the bit of num from ith to jth
    public int clearBit(int num, int j , int i){
    	int mask1 = (~0) << (j + 1);/*Obtain 1s before position j*/
    	int mask2 = (1 << i) - 1;/*Obtain 1s after position i*/
    	int mask = mask1 | mask2;
    	return num & mask;
    }
    
    //Insert M into N from i to j
    public int insert(int N, int M,int i, int j){
    	N = clearBit(N,j,i);
    	M = M << i;
    	return N | M;
    }
    
  
	public static void main(String[] args) {
		Solution01 t = new Solution01();
		int N = 1024;
		System.out.println(Integer.toBinaryString(N));
		int M = 19;
		System.out.println(Integer.toBinaryString(M));
		System.out.println(Integer.toBinaryString(t.insert(N, M, 2, 6)));

	}

}
