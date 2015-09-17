package ch1;

public class Solution15 {
	public boolean isOneEdit(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) > 1) // if the difference of their length
			                                         //larger than 1, return false
			return false;
		if (s1.length() == s2.length())
			return isReplace(s1, s2);
		else
			return isOneAddOrDel(s1, s2);
	}

	public boolean isReplace(String s1, String s2) {
		boolean isDifferent = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (isDifferent) // check if it is the first different
									// characters in two strings
					return false;
				else
					isDifferent = true;
			}
		}
		return true;
	}

	public boolean isOneAddOrDel(String s1, String s2) {
		String t1 = s1.length() > s2.length() ? s1 : s2;
		String t2 = s1.length() > s2.length() ? s2 : s1;
		int index1 = 0, index2 = 0;
		while (index1 < t1.length() && index2 < t2.length()) {
			if (t1.charAt(index1) != t2.charAt(index2)) {
				if (index1 != index2) // it means this is not the first character 
					                  //which is different for two strings
					return false;
				else
					index1++;// increase the index to ensure if they are one
								// edit, then the rest of two strings is equal
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution15 t = new Solution15();
		String s1 = "pale";
		String s2 = "ple";
		String s3 = "pele";
		String s4 = "paa";
		System.out.println(t.isOneEdit(s1, s2));
		System.out.println(t.isOneEdit(s1, s3));
		System.out.println(t.isOneEdit(s1, s4));
	}

}
