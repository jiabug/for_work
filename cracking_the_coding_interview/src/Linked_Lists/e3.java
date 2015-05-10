package Linked_Lists;
/*
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only
 * access to that node.
 */
public class e3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean deleteNode(Node n){
		if (n == null || n.next == null){
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

}
