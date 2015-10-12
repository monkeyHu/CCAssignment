package ch8;
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution03 {
    static int MAXM = 1001;//Max A.length
    static int MAXN = 100005;//Max value of coins
    static long MOD =1000000007;
    static long[][] S = new long[MAXM][MAXN]; //Store the result             
   
    static long[] countPaths(int[] A, int[] T) {
         long[] ret = new long[T.length]; //return value  
        //S[i][j] represent use 0..ith type of coin to obtian j value
           for(int i = 0; i < A.length;i++)//if value is 0
            S[i][0] = 1;          
          for(int j = 0; j*A[0] < MAXN;j++)//if only one coin
            S[0][j*A[0]] = 1;
        
            for(int i = 1; i < A.length; i++){
                for(int j = 0; j < MAXN; j++){
                  if(S[i][j] == 0){
                      S[i][j] = S[i-1][j];// use 0..i-1 type of coin to obtain j value              
                      if(j-A[i] >= 0){
                         S[i][j] += S[i][j-A[i]]%MOD;//puls use 0...i type of value to obtian j - A[i] value
                       }         
                    }
                 }     
             }
           for(int k = 0; k < T.length; k++)
               ret[k] = S[A.length-1][T[k]]%MOD; 
           return ret;
    }
    
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] A = new int[split.length];
        for(int i=0; i<split.length; i++)
            A[i] = Integer.parseInt(split[i]);
        int N = Integer.parseInt(in.nextLine().trim());
        int[] T = new int[N];
        for(int i=0; i<N; i++) {
            T[i] = Integer.parseInt(in.nextLine().trim());
        }
        long[] countPaths = countPaths(A, T);
        for(long c : countPaths)
            System.out.println(c);
        in.close();
  }
}

