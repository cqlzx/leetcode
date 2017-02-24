package leetcode;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {2, 3, 4, 5, 6};
		double result = findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        
        if((k & 1) == 1){
        	return findKthSmallest(nums1, 0, m, nums2, 0, n, k / 2 + 1);
        }else{
        	return (findKthSmallest(nums1, 0, m, nums2, 0, n, k / 2) + findKthSmallest(nums1, 0, m, nums2, 0, n, k / 2 + 1)) / 2.0;
        }
    }

    private static int findKthSmallest(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, int k){
    	
    	if(start1 == end1){
    		return arr2[start2 + k - 1];
    	}
    	if(start2 == end2){
    		return arr1[start1 + k - 1];
    	}
    	
    	if(k == 1){
    		return min(arr1[start1], arr2[start2]);
    	}
    	
    	int p1 = min(k / 2, end1), p2 = min(k / 2, end2);
    	
    	if(arr1[start1 + p1 - 1] < arr2[start2 + p2 - 1]){
    		return findKthSmallest(arr1, start1 + p1, end1, arr2, start2, end2, k - p1);
    	}else{
    		return findKthSmallest(arr1, start1, end1, arr2, start2 + p2, end2, k - p2);
    	}

    }
    
    private static int min(int a, int b){
    	return a < b ? a : b; 
    }
}