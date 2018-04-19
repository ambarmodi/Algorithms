package Trees;

/**
 * Description: Different Tree Comparison algorithms.
 *
 *1. Given two binary trees, check if they are the same or not.
 * Leetcode: https://leetcode.com/problems/same-tree/description/
 * 
 * @author ambarmodi
 */
public class TreeComparision {
	public static void main(String[] args) {
		TreeNode p = new TreeNode(2);
		p.left = new TreeNode(1);
		p.right = new TreeNode(3);
		
		TreeNode q = new TreeNode(2);
		q.left = new TreeNode(1);
		q.right = new TreeNode(3);
		System.out.println(isSameTree(p,q));
	}
	
	/**
	 * Approach: To check each node of p and q.
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		
		if(p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		
		return false;
	}
}
