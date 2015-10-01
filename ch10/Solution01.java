package ch10;

//Given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B, write a method to merge B
//into A in sorted order
public class Solution01 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexm = m - 1;//Index of last element in array nums1
        int indexn = n - 1;//Index of last element in array nums2
        int count = m + n -1;//end of merged array
        
        /*Merge nums1 and nums2, starting from the end*/
        while(indexm >= 0 && indexn >= 0){
            if(nums1[indexm] > nums2[indexn]){
                nums1[count--] = nums1[indexm--];
            }
            else{
                nums1[count--] = nums2[indexn--];
            }
        }
        //if there are elements left in nums2, copy them into nums1
        while(indexn >= 0){
            nums1[count--] = nums2[indexn--];
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution01 t = new Solution01();
		int[] a = {1,3,5,7,9,0,0,0};
		int[] b = {2,4,6};
		t.merge(a, 5, b, 3);
		for(int i :a)
			System.out.print(i + " ");
		System.out.println();

	}

}
