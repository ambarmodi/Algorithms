package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ambarmodi
 * 
 * Description: 
 * 1. Given a BINARY TREE, print the nodes level by level.
 * 2. Print the height of the Tree.
 * 
 */
public class LevelOrderTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(0);

		levelOrder(root);
		
		System.out.println("Height of the Tree is: " + getDepth(root));
	}

	/**
	 * This function prints the height of the Tree.
	 * 
	 * TC: O(n)
	 */
	private static int getDepth(TreeNode root) {
		if(root==null) {
			return 0;
		} else{
			return getDepthHelper(root,0);
		}
	}

	/**
	 * Helper Function to get the height of the Tree.
	 */
	private static int getDepthHelper(TreeNode root, int height) {
		int lHeight=0,rHeight=0;
		if(root.left==null && root.right==null)
			return height;
		if(root.left!=null){
			lHeight =  getDepthHelper(root.left, height+1);
		}
		if(root.right!=null){
			rHeight = getDepthHelper(root.right, height+1);
		}
		
		return (lHeight > rHeight) ? lHeight:rHeight;
		
	}

	/**
	 * Print level order traversal 
	 * 
	 * Idea: Uses two counters which maintains the
	 * number of items added in the queue at each level
	 * 
	 * TC: O(N)
	 * SC: O(N)
	 */
	private static void levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		int currCnt = 0, levelCnt = 0;
		levelCnt++;
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();

			if (temp.left != null) {
				q.add(temp.left);
				currCnt++;
			}
			if (temp.right != null) {
				q.add(temp.right);
				currCnt++;
			}

			System.out.print(temp.val + " ");
			levelCnt--;

			if (levelCnt == 0) {
				levelCnt = currCnt;
				currCnt = 0;
				System.out.println(""); /*This breaks the line denoting nw level.*/

			}
		}

	}
}
