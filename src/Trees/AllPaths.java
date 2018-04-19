package Trees;

import java.util.*;

/**
 * Description: Print all the paths from root to leaf in a BT.
 * 
 * @author ambarmodi
 *
 */
public class AllPaths {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.right = new TreeNode(5);
	
		binaryTreePaths(node);
	}

	/**
	 * Public function to trace all the paths of BT TC: O(n)
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		String path = new String();

		if (root != null) {
			binaryTreePathRec(root, result, path);
		}

		System.out.println(result);

		return result;
	}

	/**
	 * Recursive traversal to trace all the paths.
	 */
	private static void binaryTreePathRec(TreeNode root, List<String> result, String path) {

		//Below is the to make path look aligned
		path = (path.length() == 0) ? (new Integer(root.val).toString())
				: (path + "->" + new Integer(root.val).toString());
		if (root.left == null && root.right == null) {
			result.add(new String(path));
		} else {
			if (root.left != null)
				binaryTreePathRec(root.left, result, path);
			if (root.right != null)
				binaryTreePathRec(root.right, result, path);
		}
	}
}
