package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ambarmodi
 * 
 *         Description: Check if two nodes are siblings Question:
 *         https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
 *
 */
public class CousinNodes {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);

		TreeNode a = root.left.left;
		TreeNode b = root.right.left;

		System.out.println(isCousins(root, a, b));
	}

	/**
	 * Brute Force(Naive approach) where I am maintaining two Maps. Both the
	 * maps contains all the information about every node and at the end we
	 * simple query the map to get the results.
	 * 
	 * Issue: Exhaustive search, Space complexity is O(n)
	 */
	private static boolean isCousins(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null)
			return false;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		// Hold all the parent of all the nodes
		HashMap<TreeNode, TreeNode> parents = new HashMap<>();

		// Hold level of all the nodes
		HashMap<TreeNode, Integer> nodeLevel = new HashMap<>();
		int currCnt = 0, levelCnt = 1;

		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			levelCnt--;
			System.out.print(temp.val + " ");

			if (temp.left != null) {
				currCnt++;
				queue.add(temp.left);
				parents.put(temp.left, temp);
				nodeLevel.put(temp.left, level);
			}
			if (temp.right != null) {
				currCnt++;
				queue.add(temp.right);
				parents.put(temp.right, temp);
				nodeLevel.put(temp.right, level);
			}
			/* Logic to get check the level */
			if (levelCnt == 0) {
				levelCnt = currCnt;
				currCnt = 0;
				level++;
				System.out.println("Level#:" + level);
			}
		}
		return (parents.get(a) != parents.get(b) && nodeLevel.get(a) == nodeLevel.get(b));
	}
}
