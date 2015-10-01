package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.BitSet;
import java.util.Scanner;

/*Given an input file with four billion non-negative integers, provide an algorithm to generate an integer that is
 * not contained in the file. Assume you hava 1GB of memory available for the task,
 * There are a total of 2^32 distince integers possible and 2^31 non-integers, therefor, there must be duplicated in
 * the input file
 */
public class Solution07 {
	public void findOpenNumber(String fileName) throws FileNotFoundException{
		BitSet bs = new BitSet(400000000);//it is initialized with 0s by default
		@SuppressWarnings("resource")
		Scanner in = new Scanner(new FileReader(fileName));
		while(in.hasNextInt()){
			int n = in.nextInt();
			bs.set(n);
		}	
		for(int i = 0; i < 400000000;i++){
			if(!bs.get(i))
				System.out.println(i);
		}
	
	}
}
