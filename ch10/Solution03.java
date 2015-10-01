package ch10;

/*Given a sorted array of n integers that has been rotated an unknown number of times, assume that the array was
 * orginally sorted in increasing order, try to find an element in the array
 */
public class Solution03 {
	// Binary search, if value of mid larger than the value of low, then we can know the first half is sorted
	 //then we can check if target is in ranged in value of low and value of mid,if not, check the second half
	public int binarySearch(int[] nums, int low, int high, int target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			//Check if value of mid is larger than value of low
			if (nums[mid] > nums[low]) {
				if (nums[low] <= target && target < nums[mid]) {
					return binarySearch(nums, low, mid - 1, target);
				} else {
					return binarySearch(nums, mid + 1, high, target);
				}
			} else if (nums[mid] < nums[high]) {//Check if value of mid is less than vaule of high
				if (nums[mid] < target && target <= nums[high]) {
					return binarySearch(nums, mid + 1, high, target);
				} else {
					return binarySearch(nums, low, mid - 1, target);
				}
			} else if (nums[low] == nums[mid]) { // if value of mid is equal to value of low
				if (nums[mid] != nums[high])//First check if value of right is equal to vaule of mid
					return binarySearch(nums, mid + 1, high, target);
				else {
					//if value of right is equal to value of left and mid, first search the left part, if not found,search the right part
					int result = binarySearch(nums, low, mid - 1, target);
					if (result == -1)
						return binarySearch(nums, mid + 1, high, target);
					else
						return result;
				}
			}
		}
		return -1;
	}

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		return binarySearch(nums, low, high, target);
	}

	public static void main(String[] args) {
		Solution03 t = new Solution03();
		int[] arrays = { 2, 4, 2, 2, 2 };
		System.out.println(t.search(arrays, 4));
	}

}
