package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Basic Tree operations.
 * 
 * @author ambarmodi
 *
 */
public class TreeOps {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(1);
		node.right = new TreeNode(3);
		/*node.left.left = new Node(2);
		node.left.right = new Node(4);
		node.right.right = new Node(7);
		/*node.right.right = new Node(5);
		node.right.right.right = new Node(7);
		node.right.right.right.right = new Node(7);
		node.right.right.right.right.left = new Node(7);*/
		
		System.out.println(sumTok(node,12));
		System.out.println(height(node));
		//System.out.println(findTilt(node));
		System.out.println(findTarget(node, 2));
	}

	 /**
	 * @param root
	 * @param k
	 * @return
	 */
	public static boolean findTarget(TreeNode root, int k) {
		 return findTarget1(root,root,k);
	        
	    }
	                                     
	private static boolean findTarget1(TreeNode root, TreeNode node, int k) {
		
		 if(node!=null){
	            if(findTargetHelper(root,node,k-node.val)) return true;
	       } else{
	    	   return false;
	       }
	        
	        return findTarget1(root,node.left,k) || findTarget1(root,node.right,k);
	}

	public static boolean findTargetHelper(TreeNode root, TreeNode node, int val) {
		if (root != null) {
			if (val < root.val) {
				return findTargetHelper(root.left,node, val);
			} else if (val > root.val) {
				return findTargetHelper(root.right,node, val);
			} else if (val == root.val && node!=root)
				return true;
		}
		return false;
	}
	    
	 /**
	 * Find tilt of Tree
	 */
	public static int findTilt(TreeNode root) {
	        return findTiltHelper(root,0);
	    }
	
	private static int findTiltHelper(TreeNode node,int treeTilt) {
		if(node==null) return 0;
		
		int lTilt = findTiltHelper(node.left,treeTilt);
		int rTilt = findTiltHelper(node.right,treeTilt);
		treeTilt += Math.abs(lTilt - rTilt);	
		
		return lTilt+rTilt+node.val;
	}

	/**
	 * Returns the Height of the Tree.
	 */
	private static int height(TreeNode node) {
		return heightOfTree(node,0);
	}

	private static int heightOfTree(TreeNode node, int height) {
		if(node==null) return height;
		int lHeight = heightOfTree(node.left, height+1);
		int rHeight = heightOfTree(node.right, height+1);
		return lHeight > rHeight ? lHeight:rHeight;
	}

	/**
	 * Prints the list of Paths
	 */
	private static boolean sumTok(TreeNode node,int k) {
		//***Prints the Path
		List<List<Integer>> res= new ArrayList<List<Integer>>();
		listSumTokPaths(node,k,0,new ArrayList<Integer>(),res);
		System.out.println(res);
		
		return hasPathSum(node,k);
	}

	/**
	 * Checks if it has path with sum = k
	 */
	private static boolean hasPathSum(TreeNode node, int k) {
		if(node==null) return false;
		
		if(node.isLeaf() && k-node.val == 0) return true;
		
		return hasPathSum(node.left, k-node.val) || hasPathSum(node.right, k-node.val);
	}

	private static boolean hasPathSumHelper(TreeNode node, int k, int sum) {
		if (node == null)
			return false;

		sum += node.val;
		if (node.left == null && node.right == null) {
			if (sum == k)
				return true;
			else
				return false;
		}

		return hasPathSumHelper(node.left, k, sum) || hasPathSumHelper(node.right, k, sum);
	}
	
	
	/**
	 * List all the paths adding to sum
	 */
	private static void listSumTokPaths(TreeNode node, int k, int sum, ArrayList<Integer> temp,
			List<List<Integer>> res) {
		
		if(node!=null){
			System.out.println(temp);
			sum+=node.val;
			temp.add(node.val);
			
			if(node.isLeaf() && sum==k) {
				res.add(new ArrayList<Integer>(temp));
			}
			
			listSumTokPaths(node.left, k,sum,temp,res);
			listSumTokPaths(node.right, k,sum,temp,res);
			temp.remove(temp.size()-1);
		}	
	}
}
