package ch5;

public class Solution02 {

	public String printBinary(double num) {
		/*Check if num > 0 and num < 1*/
		if (num >= 1 || num <= 0)
			return "ERROR";

		double frac = 0.5;
		StringBuffer ret = new StringBuffer();
		ret.append(".");
		while (num > 0) {
			/*Check if the length is larger than 32*/
			if (ret.length() > 32)
				return "ERROR";
			if (num >= frac) {
				ret.append(1);
				num = num - frac;
			} else {
				ret.append(0);
			}
			frac = frac / 2;
		}

		return ret.toString();
	}

	public static void main(String[] args) {
        Solution02 t = new Solution02();
        System.out.println(t.printBinary(0.75));
	}

}
