package Matrix;

/*
 * Description: Rotate the matrix 90 degrees clockwise.
 * 	Leetcode: https://leetcode.com/problems/rotate-image/description/
 */

/**
 * @author ambarmodi
 */
public class RotateMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// Method1:
		rotate(matrix);
		printMatrix(matrix);

		rotate1(matrix);
		printMatrix(matrix);

	}

	/**
	 * Printing the Matrix
	 */
	private static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * Method1 : Mathematical relation.
	 * 
	 * @param matrix
	 */
	private static void rotate1(int[][] matrix) {
		int n = matrix[0].length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = tmp;
			}
		}
	}

	/**
	 * Method 2: To ROTATE: First Transpose and then Horizontally switch
	 */
	public static void rotate(int[][] matrix) {
		int len = matrix[0].length;
		if (len != matrix.length) {
			return;
		}
		// Transpose the matrix
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				swap(matrix, i, j);
			}
		}

		// Horizontally move
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][len - j - 1];
				matrix[i][len - j - 1] = temp;
			}
		}
	}

	/**
	 * Helper method to swap
	 */
	private static void swap(int[][] matrix, int i, int j) {
		int temp = matrix[j][i];
		matrix[j][i] = matrix[i][j];
		matrix[i][j] = temp;
	}
}
