package ch1;

public class Solution13 {

	public void replace(char[] s, int length) {
		int spaceNum = 0;
		/* first calculate the space number */
		for (int i = 0; i < length; i++) {
			if (s[i] == ' ')
				spaceNum++;
		}
		int lastspace = length - 1;
		for (int j = length - 1; j >= 0; j--) {
			if (s[j] == ' ') {/*
								 * if s[j] equals to space, then move elements
								 * afer position j to 2*spaceNum, since the size
								 * 20% is 2 more than the size of space
								 */
				for (int k = lastspace; k > j; k--) {
					s[k + 2 * spaceNum] = s[k];
				}
				s[j + 2 * spaceNum] = '0';
				s[j + 2 * spaceNum - 1] = '2';
				s[j + 2 * spaceNum - 2] = '%';
				spaceNum--;
				lastspace = j - 1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution13 t = new Solution13();
		char[] s = { 'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ' };
		t.replace(s, 13);
		System.out.println(s);
	}

}
