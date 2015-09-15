package ch1;

public class Solution17 {
    public void RotateMatrix(int [][]matrix, int n){
    	for(int layer = 0; layer < n/2; layer++){
    		int first = layer;
    		int last = n - layer -1;
    		for(int i = first; i < last; i++){
    			int offset = i - first;
    			int top = matrix[first][i];
    			
    			matrix[first][i] = matrix[last-offset][first];
    			
    			matrix[last-offset][first] = matrix[last][last-offset];
    			
    			matrix[last][last-offset] = matrix[i][last];
    			
    			matrix[i][last] = top;
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Solution17 t = new Solution17();
        int [][] matrix = {{1,2,3},{2,3,4},{4,5,6}};
        t.RotateMatrix(matrix, matrix.length);
        for(int i = 0 ; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		System.out.print(matrix[i][j] + " ");
        	}
        	System.out.println();
        }
	}

}
