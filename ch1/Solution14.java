package ch1;

public class Solution14 {
	/*Assume the input contains space and other characters while output only dictionary characters*/
	public boolean isPermutaionOfPalindrome(String s) {
		int oddnum = 0;
		int[] table = new int[26];/*since we assume it is not case sensitive*/
		for (int i = 0; i < s.length(); i++) {
			int charNum = getCharNum(s.charAt(i));
			if (charNum != -1) {
				table[charNum]++;
				if (table[charNum] % 2 == 1) 
					oddnum++;
				else
					oddnum--;
			}
		}
		return oddnum <= 1;
	}

	public int getCharNum(Character c) {
		int val = Character.getNumericValue(c);
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		if (val >= a && val <= z)
			return val - a;
		else if (val >= A && val <= Z)
			return val - A;
		else
			return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution14 t = new Solution14();
		String s = "Tact Coa";
		String s1 = "Tac caj";
		System.out.println(t.isPermutaionOfPalindrome(s));
		System.out.println(t.isPermutaionOfPalindrome(s1));
	}

}
