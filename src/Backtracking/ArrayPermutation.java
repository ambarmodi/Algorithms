package Backtracking;

import java.util.*;

/**
 * Description: Generate all the permutations of an integer array.
 * Refer to the explanation https://www.youtube.com/watch?v=IPWmrjE1_MU
 *
 */
public class ArrayPermutation {
	public static void main(String[] args) {
		int[] input = { 1, 2, 3 };
		List<int[]> result = permutation(input);

		for (int[] arr : result) {
			System.out.print("{");
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println("}");
		}
	}

	/**
	 * Idea is to swap each element in array with another element to generate
	 * the permutation.
	 * 
	 * TC: As base case is executed n! times and non-base case has a for loop
	 * resulting into base-case, total TC is O(n*n!)
	 */
	public static List<int[]> permutation(int[] input) {
		List<int[]> result = new ArrayList<int[]>();
		
		if(input==null || input.length ==0) return result;
		
		permutation(input, 0, result);
		return result;
	}

	/**
	 * Helper function for recursion
	 */
	private static void permutation(int[] input, int start, List<int[]> result) {
		if (start == input.length) {
			result.add(input.clone());
		} else {
			for (int i = start; i < input.length; i++) {
				swap(input, i, start);
				permutation(input, start + 1, result);
				swap(input, i, start);
			}
		}

	}

	/**
	 * Function to Swap.
	 */
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
