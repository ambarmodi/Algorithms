package Arrays;

/**
 * @author ambarmodi
 * 
 *         Description: Determine if you are able to reach the last index, given
 *         you are initially positioned at the first index of the array.
 * 
 *         For example: 
 *         A = [2,3,1,1,4], return true.
 *         A = [3,2,1,0,4], return false.
 * 
 *         Leetcode link : https://leetcode.com/problems/jump-game/description/
 */
public class CanJump {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 0, 4 };
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		boolean ret = canJumpRec(nums, 0);
		return ret;
	}

	private static boolean canJumpRec(int[] nums, int pos) {
		if (pos == nums.length - 1) {
			return true;
		}
		int maxPos = Math.min(pos + nums[pos], nums.length - 1);
		for (int i = pos + 1; i <= maxPos; i++) {
			if (canJumpRec(nums, i)) {
				return true;
			}
		}
		return false;

	}

}
