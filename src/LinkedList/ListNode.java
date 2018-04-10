package LinkedList;

/**
 * @Description: For simplicity we are assuming node has int data. Ideally there
 *               should be a Data class. This is the node for Binary Tree and
 *               will be used by all class in Trees package.
 * @author ambarmodi
 * 
 */
public class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int data){
		this.val = data;
		next=null;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		ListNode temp = this;
		while(temp!=null) {
			result.append(temp.val + " ->");
			temp=temp.next;
		}
		result.append("null");
		
		return result.toString();
	}
}
