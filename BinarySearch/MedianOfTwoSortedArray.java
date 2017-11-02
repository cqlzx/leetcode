package binarySearch;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        if (len % 2 == 0) {
            return 0.5 * (findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2) 
                          + findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2 + 1));
        } else {
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2 + 1);
        }
    }
    
    private int findKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        if (len1 > len2) return findKth(nums2, s2, e2, nums1, s1, e1, k);
        if (len1 == 0) return nums2[s2 + k - 1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);
        
        int interval1 = Math.min(k / 2, len1);
        int interval2 = k - interval1;
        int i = s1 + interval1 - 1;
        int j = s2 + interval2 - 1;
        
        if (nums1[i] >= nums2[j]) {
            return findKth(nums1, s1, e1, nums2, j + 1, e2, k - interval2);
        } else {
            return findKth(nums1, i + 1, e1, nums2, s2, e2, k - interval1);   
        }
    }
}
