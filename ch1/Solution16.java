package ch1;

public class Solution16 {
	public String stringCompression(String s) {
		StringBuffer result = new StringBuffer();
		result.append(s.charAt(0));
		int count = 1;// save the consecutive occurrences
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				count++;
			} else {
				result.append(count);
				result.append(s.charAt(i));
				count = 1;
			}

		}
		result.append(count);
		return result.toString();
	}

	public static void main(String[] args) {
		Solution16 t = new Solution16();
		String s = "aabcccccaaa";
		System.out.println(t.stringCompression(s));

	}

}
