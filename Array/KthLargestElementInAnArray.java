package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		int res = findKthLargest3(new int[]{3,2,1,5,6,4}, 4);
		System.out.println(res);
	}
	
	
	
	//Solution 1, sort the whole array, O(NlogN)
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	
	//Solution 2, Priority Queue, O(Nlogk) time
	public static int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int num : nums) {
			pq.offer(num);
			
			if (pq.size() > k){
				pq.poll();
			}
		}
		
		return pq.peek();
	}
	
	//Solution 3, design own min Heap, O(Nlogk)
	public static int findKthLargest3(int[] nums, int k) {
		int[] res = new int[k + 1];
		for (int i = 1; i <= k; i++) res[i] = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int index = 1;
			int preIndex = 0;
			while (num > res[index]) {
				int tmp = res[index];
				res[index] = num;
				res[preIndex] = tmp;
				preIndex = index;
				int leftChild = 2 * index;
				int rightChild = 2 * index + 1;
				if (rightChild <= k && res[leftChild] < num && res[rightChild] < num) {
					index = res[leftChild] > res[rightChild] ? rightChild : leftChild;
				} else if (rightChild <= k && res[rightChild] < num){
					index = rightChild;
				} else if (leftChild <= k && res[leftChild] < num) {
					index = leftChild;
				} 
			}
		}
		
		return res[1];
	}
	
	//Solution 4, quick selection, average O(N), smart solution of this problem
	public static int findKthLargest4(int[] nums, int k) {
		shuffle(nums);
		k = nums.length - k;
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int j = partition(nums, low, high);
			if (j < k) {
				low = j + 1;
			} else if (j > k) {
				high = j - 1;
			} else {
				break;
			}
		}
		
		return nums[k];
	}
	private static int partition(int[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		while (true) {
			while (i < high && a[++i] < a[low]);
			while (j > low && a[--j] > a[low]);
			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap (a, low, j);
		
		return j;
	}
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	private static void shuffle(int[] a) {
		Random random = new Random();
		for (int i = 1; i < a.length; i++) {
			int index = random.nextInt(i + 1);
			swap(a, index, i);
		}
	}
}
