package LinkedList;

/**
 * @author ambarmodi
 * 
 * Description: Remove Nodes from Singly LinkedList.
 *
 */
public class RemoveNode {
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		System.out.println(root);
		root = removeNthFromEnd(root, 2);
		System.out.println(root);

	}

	/**
	 * Problem:
	 * LeetCode: https://leetcode.com/problems/remove-nth-node-from-end-of-list
	 * 
	 * TC: O(n) -> With only one pass over the LinkedList
	 * SC: O(1)
	 * 
	 * Main dummy node at start to handle the corner case.
	 * 
	 */
	private static ListNode removeNthFromEnd(ListNode root, int n) {
		if(root==null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next =root;
		
		ListNode fst=dummy,snd=dummy;
		
		for(int i=0;i<n;i++) {
			snd=snd.next;
		}
		
		while(snd!=null && snd.next!= null) {
			fst=fst.next;snd=snd.next;
		}
		fst.next = fst.next.next;
		
		return dummy.next;
	}
}
