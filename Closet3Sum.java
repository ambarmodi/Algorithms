package com.easy;
import java.util.*;

/*
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 *  
 * Problem Description: https://leetcode.com/problems/3sum-closest/description/
 */

/**
 * @author ambarmodi
 */
public class Closet3Sum {
	public static void main(String[] args) {
		//Sample input
		int nums[] = {-1,-4,1,2};
		int target = 1;
		
		//Answer: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
		System.out.println(threeSumClosest(nums, target));
		
	}
		    
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		if(nums.length <3){
			return target;
		}
		
		int result = nums[0]+nums[1]+nums[nums.length-1];
		
		for(int i=0;i<nums.length;i++) {
			int lo=i+1,hi= nums.length-1;
			while(lo < hi){
				int sum = nums[i]+nums[lo] + nums[hi];
				if(sum>target) hi--;
				else lo++;
				
				if(Math.abs(sum-target) < Math.abs(result-target)){
					result = sum;
				}
			}	
		}
		return result;
	}
}
