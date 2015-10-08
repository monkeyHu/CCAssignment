package ch5;

public class Solution05 {
/* n & (n -1 ) = 0 means there are no common 1s in n and n - 1
 * if n = abcdef1000
 * then n - 1 = abcdef0111
 * since n & (n-1) = 0
 * so abcdef must be 0
 * then n = 0000..001000
 * which means n is power of 2
 * so the code n & ( n - 1) = 0 check if n is power of 2
 */
}
