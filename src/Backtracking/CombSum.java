package Backtracking;

import java.util.*;

/**
 * @author ambarmodi
 * 
 *         Description: Given a set of candidate numbers (C) (without
 *         duplicates) and a target number (T), find all unique combinations in
 *         C where the candidate numbers sums to T
 * 
 *         Leetcode link: https://leetcode.com/problems/combination-sum/
 *
 */
public class CombSum {
	public static void main(String[] args) {
		int[] list = { -3, -2, -1, 0, 0, 1, 2, 3, 1 };
		System.out.println(combinationSum(list, 7));
	}

	public static List<List<Integer>> combinationSum(int[] elem, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();

		int start = 0;
		combRec(elem, target, result, curr, start);
		return result;
	}

	/**
	 * Helper recursive function.
	 */
	private static void combRec(int[] elem, int target, List<List<Integer>> result, List<Integer> curr, int start) {
		if (target > 0) {
			for (int i = start; i < elem.length; i++) {
				//Condition to handle duplicates
				if (i > start && elem[i] == elem[i - 1]) { 
					continue;
				}
				curr.add(elem[i]);
				combRec(elem, target - elem[i], result, curr, i + 1);
				curr.remove(curr.size() - 1);
			}
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(curr));
		}
	}

}
