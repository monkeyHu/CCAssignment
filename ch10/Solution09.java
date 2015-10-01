package ch10;

/*Given an M*N matrix in which each row and each column is sorted in ascending order,write a method to find 
 * an element
 */
public class Solution09 {
	public boolean findElement(int[][] matrix,int target){
		int row = 0;
		int column = matrix[0].length - 1;
		//Comparision begin from the last column and first row
		while(row < matrix.length && column >= 0){
			if(matrix[row][column]==target){
				return true;
			}else if(matrix[row][column] > target){ // if the target is less than matrix[row][column], it must be in the left of that column
				column--;
			}else{
				row++; //the target is larger than matrix[row][column], it must be below that low
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int [][] arrays = {{15,20,40,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};
		Solution09 t = new Solution09();
		System.out.println(t.findElement(arrays, 55));

	}

}
