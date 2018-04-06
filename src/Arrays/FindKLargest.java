package Arrays;

/**
 * @author ambarmodi
 * 
 *         Description: Find the kth largest element in an unsorted array.
 * 
 *         For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 */
public class FindKLargest {
	public static void main(String[] args) {
		int[] list = { 2, 3, 1, 5, 6, 4 };
		int k = 1;

		System.out.println(findKthLargest(list, k));
	}

	/**
	 * Solution: Quick-Select
	 * 
	 * TC: O(nlgn)
	 * 
	 * Put index at K and apply quick sort. In this case, all element less than
	 * index (K) will be on left and all greater than K will be on right. The
	 * value at K will be the result.
	 */
	public static int findKthLargest(int[] nums, int k) {
		int index = nums.length - k;
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int p = partition(nums, low, high);
			if (p < index) {
				low = p + 1;
			} else if (p > index) {
				high = p - 1;
			} else
				return nums[index];
		}

		return nums[index];
	}

	private static int partition(int[] nums, int low, int high) {
		int pivot = high;
		System.out.println("in p");
		int start = low;
		for (int i = low; i <= high; i++) {
			if (nums[i] < nums[pivot]) {
				swap(nums, start, i);
				start++;
			}
		}
		swap(nums, start, high);

		return start;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp;
		if (i != j) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

}
