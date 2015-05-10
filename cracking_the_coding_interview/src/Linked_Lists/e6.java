package Linked_Lists;
/*
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of
 * the loop.
 */

public class e6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Node FindBeginning(Node head){
		Node fast = head;
		Node slow = head;
		//Find meeting point, This will be LOOP_SIZE - k steps into the linked list
		while (fast != null && fast.next != null){//check whether there is a loop
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){//collision
				break;
			}
		}
		
		//error check -- no meeting point, and therefore no loop
		if (fast == null || fast.next == null){
			return null;
		}
		
		slow = head;
		while (slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
