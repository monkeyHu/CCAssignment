package ch1;

public class Solution17 {
	public void RotateMatrix(int[][] matrix, int n) {
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1; j++) {
				// save top
				int temp = matrix[i][j];
				// left to top
				matrix[i][j] = matrix[n - 1 - j][i];
				// right to left
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				// bottom to right
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				// top to right
				matrix[j][n - 1 - i] = temp;
			}
		}

	}

	public static void main(String[] args) {
		Solution17 t = new Solution17();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		t.RotateMatrix(matrix, matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
