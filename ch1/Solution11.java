package ch1;

public class Solution11 {
	public boolean isUnique(String s) {
		if (s.length() > 128)
			return false;
		int[] charNum = new int[128]; /* since there are only 128 ASCII characters,so we can use a array of
		                                  size 128 to record the occurrence of each character */
		for (int i = 0; i < s.length(); i++) {
			charNum[s.charAt(i)]++;
			if (charNum[s.charAt(i)] > 1) // if the occurrence of a character is
											// more than 1 return false
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// Test
		Solution11 test = new Solution11();
		String s = "aba";
		System.out.println(test.isUnique(s));
		String s1 = "ab";
		System.out.println(test.isUnique(s1));
	}

}
