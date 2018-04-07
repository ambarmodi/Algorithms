package Arrays;
import java.util.*;

/**
 * Description: Handling the Missing number for list 1 to N. 
 * For Example: Input:
 * {3,2,1,5,4,7} has missing number 6.
 *
 * @author ambarmodi
 * 
 */
public class MissingNumber {
	public static void main(String[] args) {

		int[] input = new int[] { 3, 2, 1, 5, 4, 7 };
		// If the summation of number does not cause a overflow.
		System.out.println(missingNumber(input));

		// Solution using Bit Manipulation:
		System.out.println(missingNumberXOR(input));

		// If input is a sorted array.
		Arrays.sort(input);
		System.out.println(missingNumberSorted(input));
	}

	/**
	 * TC: O(N) SC: O(1)
	 * 
	 * Issue: Can cause overflow as the sum might go out of integer range. 
	 * 
	 */
	private static int missingNumber(int[] nums) {
		if (nums == null | nums.length == 0)
			return 0;

		int N = nums.length + 1;
		int orgSum = (int) (N * (N + 1) / 2.0);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return orgSum - sum;
	}

	/**
	 * Solution using XOR. 
	 * 
	 * Idea: a^b^b = a. so if there is a duplicate number
	 * the XOR of that will be 0. We can use the same idea where the (index+1)
	 * and corresponding number cancel out itself.
	 */
	private static int missingNumberXOR(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = num ^ (i + 1) ^ nums[i];
		}
		return num ^ nums.length + 1;
	}

	
	/**
	 * Solution: if input is SORTED. Can solve using QuickSelect approach!
	 * 
	 * TC: O(lgn) SC: O(1)
	 */
	private static int missingNumberSorted(int[] nums) {
		int pivot = 0;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			pivot = (left + right) / 2;
			if (nums[pivot] > pivot + 1) {
				right = pivot;
			} else {
				left = pivot + 1;
			}
		}
		return (nums[left] == left + 1) ? left + 2 : left + 1;
	}
}
