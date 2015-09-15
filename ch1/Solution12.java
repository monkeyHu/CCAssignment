package ch1;
import java.util.Arrays;

public class Solution12 {
	public boolean checkPermutaion(String s1, String s2) {
		/*
		 * First check the length of two strings, if they are not equal, return
		 * false
		 */
		if (s1.length() != s2.length())
			return false;
		char[] ts1 = s1.toCharArray(); 
		char[] ts2 = s2.toCharArray();
		Arrays.sort(ts1);// sort s1
		Arrays.sort(ts2);// sort s2
		boolean result = Arrays.equals(ts1, ts2); // if they are equal after
													// sorting, return true
		return result;
	}

	public static void main(String[] args) {
		// Test
		Solution12 test = new Solution12();
		String s = "aba";
		String s1 = "abc";
		System.out.println(test.checkPermutaion(s, s1));
		s1 = "aab";
		System.out.println(test.checkPermutaion(s, s1));
	}

}
