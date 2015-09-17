package ch1;

public class Solution18 {
	public void setZeors(int matrix[][]) {
		boolean zeroRows[] = new boolean[matrix.length];//save the rows which have zero
		boolean zeroCols[] = new boolean[matrix[0].length];//save the columns which have zero
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					zeroRows[i] = true;
					zeroCols[j] = true;
				}
			}
		}
		for (int i = 0; i < zeroRows.length; i++) {
			if (zeroRows[i]) {
				for (int j = 0; j < zeroCols.length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < zeroCols.length; i++){
			if(zeroCols[i]) {
				for(int j = 0; j < zeroRows.length; j++){
					matrix[j][i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
      Solution18 t = new Solution18();
      int[][] matrix = {{1,2,3},{1,0,1},{2,2,0}};
      t.setZeors(matrix);
      for(int i = 0; i < matrix.length; i++){
    	  for(int j = 0; j < matrix[0].length; j++){
    		  System.out.print(matrix[i][j]+ " ");
    	  }
    	  System.out.println();
      }
	}

}
