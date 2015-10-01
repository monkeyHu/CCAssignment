package ch10;

/*Given an array of integers, sort the array into an alternating sequence of peaks and valleys,
 * EXAMPLE: Input:{5,3,1,2,3}
 * Output:{5,1,3,2,3}
 */
/*We can regard 3 digits as a unit, and find the max of these three digits, then swap it with the middle element
 * And because in the previous 3 digits, the right element is a valley, for the next three elements, if the left 
 * element is the largest(which is the right element of the previous three digits), then we swap the middle elements
 * with the left element which means the middle element is a smaller element than left, so the valley peak valley mode
 * won't be broken
 */
public class Solution11 {
	public void sortValleyPeak(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			int maxIndex = maxIndex(array, i - 1, i, i + 1);
			swap(array, i, maxIndex);
		}
	}

	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public int maxIndex(int[] array, int a, int b, int c) {
		int len = array.length;
		int av = (a >= 0 && a <= len) ? array[a] : Integer.MIN_VALUE;
		int bv = (b >= 0 && b <= len) ? array[b] : Integer.MIN_VALUE;
		int cv = (c >= 0 && c <= len) ? array[c] : Integer.MIN_VALUE;

		int max = Math.max(av, Math.max(bv, cv));
		if (max == av)
			return a;
		else if (max == bv)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
	  Solution11 t = new Solution11();
	  int a[] = {5,3,1,2,3};
	  t.sortValleyPeak(a);
	  for(int i:a)
		  System.out.print(i + " ");

	}

}
