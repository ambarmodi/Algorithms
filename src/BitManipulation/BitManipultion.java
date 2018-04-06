package BitManipulation;

/**
 * @author ambarmodi
 * 
 *         Description: Some Basic Bit Manipulation operations:
 */
public class BitManipultion {

	public static void main(String[] args) {

		System.out.println("Compliment of 5 is " + findComplement(5));
		System.out.println("Bit representation of 15 is " + bitRepresent(15));
		System.out.println("128 is power of two: " + isPowerOfTwo(128));
		System.out.println("Hamming Distance= " + hammingDistnce(4, 2));
		System.out.println("Number of set bit in 15 are " + bitCount(15));
	}

	/**
	 * Count number of 1.
	 * 
	 * Java has a Integer.bitCount().
	 * 
	 * @return
	 */
	public static int bitCount(int n) {
		int count = 0;
		while (n > 0) {
			count += (n & 1);
			n = n >> 1;
		}
		return count;
	}

	/**
	 * Hamming distance: Distance between two set bits.
	 */
	private static int hammingDistnce(int x, int y) {
		int distance = 0;
		int temp = x ^ y;
		// System.out.println(Integer.toBinaryString(temp));
		while (temp > 0) {
			if ((temp & 1) == 1)
				distance++;
			temp = temp >> 1;
		}
		return distance;
	}

	/**
	 * Power of 2 using LOG
	 */
	private static boolean isPowerOfTwo(int num) {
		double val = (Math.log(num) / Math.log(2));
		return Math.ceil(val) == Math.floor(val);
	}

	/**
	 * Finding Compliment by Masking
	 */
	public static int findComplement(int num) {
		int mask = 1;
		while (mask < num) {
			mask = (mask << 1) | 1;
		}
		return ~num & mask;
	}

	/**
	 * Represent numbers in Bit
	 */
	public static String bitRepresent(int num) {
		return Integer.toBinaryString(num);
	}

}
