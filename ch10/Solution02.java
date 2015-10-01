package ch10;

import java.util.Arrays;
import java.util.Comparator;

/*Sort an array of strings so that all the anagrams are next to each other*/
/*Anagrams: words that have the same characters but in different orders*/
/*Time complexity: O(nlogn)*/
public class Solution02 {
	public void sort(String[] s) {
		Arrays.sort(s, new AnagramComparator());
	}

	/*First sort the string according to the alphabetic, so the anagram will be sorted in the nearby postion*/
	public class AnagramComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			char[] sc1 = s1.toCharArray();
			Arrays.sort(sc1);
			s1 = new String(sc1);
			char[] sc2 = s2.toCharArray();
			Arrays.sort(sc2);
			s2 = new String(sc2);
			return s1.compareTo(s2);
		}
	}
	
	public static void main(String[] args) {
		String s[] = {
		        "axyz", "abc", "yzax", "bac", "zyxa", "fg", "gf"
		    };
		   Solution02 t = new Solution02();
		   t.sort(s);
		   for(String string:s){
			   System.out.println(string);
		   }

	}
}
