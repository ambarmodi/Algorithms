package Trees;

/**
 * Description: Convert BST to the Greater Tree where original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 * 
 * Leetcode Link:
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 * 
 * @author ambarmodi
 *
 */
public class GreaterTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);

		root.left = new TreeNode(4);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(14);

		root = convertBST(root);
		System.out.println(root);
	}

	/**
	 * Approach: Reversed In-order Traversal 
	 * 
	 * The idea is to traverse tree in Descending order maintaining the sum.
	 * Update each node with the sum.
	 */
	public static TreeNode convertBST(TreeNode root) {
		convertBST(root, 0);
		return root;
	}

	/**
	 * We can use the helper function to maintain the sum. 
	 * ALTERNATIVELY we don't need the helper function and we can 
	 * have the sum variable defined as global/class variable
	 */
	private static int convertBST(TreeNode root, int sum) {
		if (root != null) {
			sum = convertBST(root.right, sum);
			root.val = sum + root.val;
			sum = root.val;
			sum = convertBST(root.left, sum);
		}
		return sum;
	}

}
