package ch8;

public class Solution01 {
	/*
	 * Complete the function below.
	 */
	    static long[] R = new long[100005];//Store result
	    static int MOD = 1000000007;
	    static long findPath(int[] A, int target){
	        if(target == 0){ //if  length is 0, the number of path is 1
	            return 1;
	        }
	        
	        if(R[target] == 0){ //if the length hasn't been calculated
	            for(int i = 0; i < A.length; i++){
	               if(target-A[i] >= 0){
	                  R[target] += findPath(A,target-A[i])%MOD; //the sum of the numbers of paths of the target-A[i]
	               }
	           }
	        }
	        else{//if the length has been calculated
	            return R[target]%MOD;
	        }
	        return R[target]%MOD;
	    }
	    static long[] countPaths(int[] A, int[] T) {
	         long[] ret = new long[T.length];
	         for(int k = 0; k < 10005; k++)
	             R[k] = 0;
	        //For each test case
	         for(int i = 0; i < T.length; i++){
	             ret[i] = findPath(A,T[i]);
	         }
	           return ret;
	    }
}
