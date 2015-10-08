package ch5;

/*You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length
 * of the longest sequence of 1s you could create
 * EXAMPLE
 * Input: 1775(or 11011101111)
 * Output: 8
 */
public class Solution03 {
	public int longestSequence(int n) {

		int[] sequences = { 0, 0, 0 };// Counts of last 3 sequnces
		int searching = 0;
		int maxSequence = 1;

		for (int i = 0; i < 32; i++) {
			if ((n & 1) != searching) {
				if (searching == 1) {// End of 1s + 0s + 1s Sequence
					maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
				}
				searching = n & 1;// Filp 1 to 0 or 0 to 1
				shift(sequences);// Shift sequences
			}
			sequences[0]++;
			n >>>= 1;
		}

		if (searching == 0)
			shift(sequences);

		return Math.max(maxSequence, getMaxSequence(sequences));
	}

	public int getMaxSequence(int[] sequences) {
		if (sequences[1] == 1) {// A single 0 -> Meger sequences
			return sequences[0] + sequences[2] + 1;
		} else if (sequences[1] == 0) {// no 0s -> take one side
			return Math.max(sequences[0], sequences[2]);
		} else {// Many 0s -> take side, add 1(flip a bit)
			return Math.max(sequences[0], sequences[2]) + 1;
		}
	}

	public void shift(int[] sequences) {
		sequences[2] = sequences[1];
		sequences[1] = sequences[0];
		sequences[0] = 0;
	}
	public static void main(String[] args) {
        Solution03 t = new Solution03();
        System.out.println(t.longestSequence(1775));
	}

}
