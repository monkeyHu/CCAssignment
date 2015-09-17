package ch1;

public class Solution19 {
	public boolean isStringRotation(String s1, String s2) {
		if (s1.length() != s2.length()) /* if the lengths of strings are not consistent, 
			                             they are not string rotation of each other*/
			return false;
		String s = s1 + s1;/* if s1 is divided into xy, and s2 is divided into yx,
						   * then s = xyxy,so we can check if s contains s2*/
		if (s.contains(s2))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Solution19 t = new Solution19();
		String s1 = "waterbottle";
		String s2 = "bottlewater";
		System.out.println(t.isStringRotation(s1, s2));
	}

}
