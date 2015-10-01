package ch10;

import java.util.BitSet;

/*Given an array with all the number from 1 to N, where N is at most 32000.The array may have duplicate entries and 
 * N is not given, with only 4 kilobytes of memory available,print all duplicate elements in the array
 * Since we have 4 kilobytes of memory which means we can address up to 8 * 4 * 2^10 bits, and 32 * 2^10 bits is larger
 * than 32000, so wen can create a bit vector with 32000 bits.
 */
public class Solution08 {
	public void findDuplicate(int [] array){
		BitSet bs = new BitSet(32000);//Create a bit vector with 32000 bits, each bit represents one integer
		for(int i = 0; i < array.length; i++){
			int nums = array[i];
			int index = nums - 1;//bitsets starts at 0, numbers start at 1
			if(bs.get(index)) //if the number has appeared , it means it is duplicate
				System.out.println(nums);
			else{
				bs.set(index);
			}
		}
	}
	
	public static void main(String[] args) {
		int [] array= {1,2,3,3,4,35,35};
		   Solution08 t = new Solution08();
		  t.findDuplicate(array);
	}
}
