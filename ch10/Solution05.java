package ch10;

/*Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a methods to find the
location of a given string
Example
Input ball,{"at","","","","ball","","","","car","","","dad","",""}
Output:4*/
public class Solution05 {
	public int sparseSearch(String[] strings, String str) {
		/*if strings or str is null return -1, if str is "",return -1*/
		if (strings == null || str == null || str.equals(""))
			return -1;
		int low = 0;
		int high = strings.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int temp = mid;
			/*if the string at index temp is "", we move it to the right until it doesn't equal right or it exceed
			 * the length of string array*/
			while (temp <= high && strings[temp].equals(""))
				temp++;
			/*if it exceed the length, we directly search the left part*/
			if (temp > high) {
				high = mid - 1;
			} else {
				if (str.equals(strings[temp]))
					return temp;
				else if (strings[temp].compareTo(str) < 0) {
					low = temp + 1;
				} else {
					high = temp - 1;
				}
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		String s[] = {
				"at","","","","ball","","","","car","","","dad","",""
		    };
		   Solution05 t = new Solution05();
		  System.out.println(t.sparseSearch(s, "ball"));
	}
	
}
