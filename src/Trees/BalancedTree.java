package Trees;

public class BalancedTree {
	
	public  static boolean isTreeBalance = true;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
	//	root.left = new TreeNode(4);
	//	root.right = new TreeNode(10);
	//	root.left.left = new TreeNode(2);
	//	root.left.right = new TreeNode(6);
	//	root.right.left = new TreeNode(8);
	//	root.right.right = new TreeNode(14);
		
		System.out.println(isBalanced(root));
	
		
	}

	public static boolean isBalanced(TreeNode root) {
		if(root ==null) return true;
		isTreeBalance = true;
		height(root, 0);
		 return isTreeBalance;
	}
    
    public static int height(TreeNode root,int height) {
    	if(root == null) return height;
    	int lHeigt = height(root.left,height+1);
    	int rHeigh = height(root.right,height+1);
    	if(Math.abs(lHeigt - rHeigh) >=2 ) 
    		isTreeBalance = false;
    		
    	return Math.max(lHeigt, rHeigh);
    	
    }
    
}
