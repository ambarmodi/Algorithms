package StringManipulation;

import java.util.*;

public class StringPermutation {

	public static void main(String[] args) {
		String input = "abc";
		// Approach#1
		List<String> result = generatePermutation1(input);
		System.out.println(result);
		
		// Approach#2
		result = generatePermutation2(input);
		System.out.println(result);
	}

	// ---------Approach 2---------------------
	/**
	 * Approach2: We just swap each character with other characters in input in
	 * a recursive fashion. 
	 * 
	 * TC: O(n*n!) : Each permutation is generated after n calls in 
	 * recursion tree(start=input.length()) and total number of
	 * permutations are n!
	 */
	public static List<String> generatePermutation2(String input) {
		List<String> result = new ArrayList<String>();
		if(input ==null || input.length() == 0) return result;

		helper(input, 0, result);
		return result;
	}

	/**
	 * Helper Function for approach 2
	 */
	private static void helper(String input, int start, List<String> result) {
		if (start == input.length()) {
			result.add(input);
		}
		for (int i = start; i < input.length(); i++) {
			input = swap(input, i, start);
			helper(input, start + 1, result); // S=Note: This is start+1
			input = swap(input, i, start);
		}

	}

	private static String swap(String input, int i, int j) {
		char[] res = input.toCharArray();
		char temp = res[i];
		res[i] = res[j];
		res[j] = temp;
		return new String(res);
	}
	
	
	//------------Approach 1--------------------

	/**
	 * Total Permutations should be N! for an n length string. 
	 * TC: It tricky here. TC is actual complexity of helper function.
	 * 
	 */
	public static List<String> generatePermutation1(String input) {
		List<String> result = new ArrayList<String>();
		if(input ==null || input.length() == 0) return result;
		
		generatePermutation1(input, "", result);
		return result;

	}

	/**
	 * Description: This is inspired from a backtracking approach. For each of
	 * the character in the string put that character at every possible place.
	 * 
	 * TC: So here, total n! permutations are there, so base case is called n!
	 * times. Now, we have a for loop in non-base case, which gets called n
	 * times. So total lower bound of TC is O(n*n!). If we also consider the TC
	 * of the substring here, which is O(n), then the tight upper bound comes to
	 * O(n2*n!).
	 * 
	 */
	private static void generatePermutation1(String input, String prefix, List<String> result) {
		if (input.length() == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < input.length(); i++) {
				String rem = input.substring(0, i) + input.substring(i + 1);
				generatePermutation1(rem, prefix + input.charAt(i), result);
			}
		}
	}
}
