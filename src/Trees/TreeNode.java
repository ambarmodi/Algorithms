package Trees;

/**
 * @Description: For simplicity we are assuming node has int data. Ideally there
 *               should be a Data class. This is the node for Binary Tree and
 *               will be used by all class in Trees package.
 * @author ambarmodi
 * 
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data){
		this.val = data;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString() {
		return " " + this.val;
	}
}
