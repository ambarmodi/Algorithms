package StringManipulation;

/**
 * @author ambarmodi 
 * 
 * Description: Implement atoi to convert a string to an
 *         integer. Example: "-00234" --> -00234 LeetCode:
 *         https://leetcode.com/problems/string-to-integer-atoi/description/
 *         
 *         TC: O(n)
 *         SC: O(1)
 * 
 *Requirement: 
 *		   1. Can the number be negative. : Yes 
 *         2. Will be number have leading 0 : Yes 
 *         3. Will it be a floating number: No 
 *         4. Will the input be valid integer? No, ignore the white-space characters before and
 *            after the integer eg: "  -432gf" is -432 
 *         5. Will it be in range. No, if goes out of range return INT_MAX (2147483647)
 *            or INT_MIN (-2147483648). 
 *         6. If input cannot be converted return 0.
 *        
 */
public class StringToInteger {
	public static void main(String[] args) {
		String input = " -12";
		System.out.println(aToI(input));
	}

	private static int aToI(String input) {
		int res = 0, i = 0, isNeg = 1;

		/*Remove space*/
		while (i < input.length() && (input.charAt(i) == ' ')) i++;
		
		/*Take the sign bit*/
		if (input.charAt(i) == '-' || input.charAt(i) == '+') {
			isNeg = (input.charAt(i) == '-') ? -1 : 1;
			i++;
		}
		
		/*Parse the string*/
		while (i < input.length()) {
			int val = input.charAt(i++) - '0';
			if (val > 9 || val < 0)
				break;
			int temp = res * 10 + val;
			if (temp / 10 == res) {
				res = temp;
			} else 
				return (isNeg == -1) ? -2147483648 : 2147483647;
		}
		return isNeg * res;
	}
}
