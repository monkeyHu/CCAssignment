package ch10;

import java.util.ArrayList;

//Given a structure which has a elementAt funciton and dosen't have a size function, which contains sorted,positive
//integers, find the index at which an element x occurs
public class Solution04 {
	public class Listy {
		ArrayList<Integer> list;

		public int elementAt(int index) {
			return list.get(index);
		}

		public Listy() {
			this.list = new ArrayList<Integer>();
		}
	}

	public int search(Listy list, int target) {
		int index = 1;
		//Fisrt find the list length
		while (list.elementAt(index) != -1 && list.elementAt(index) < target) {
			index = index * 2;
		}
		return binarySearch(list, target, index / 2, index);
	}

	public int binarySearch(Listy list, int target, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			int middleElement = list.elementAt(mid);
			if ((target < middleElement) || (middleElement == -1))
				high = mid - 1;
			else if (target > middleElement) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
