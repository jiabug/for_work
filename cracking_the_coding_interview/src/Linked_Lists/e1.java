package Linked_Lists;

import java.util.HashSet;

/*
 * Write code to remove duplicates from an unsorted linked lists.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class e1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	void deleteDups(Node n){//n is head
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while (n != null){
			if (set.contains(n.data)){
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	void deleteDups_1(Node head){//no buffer allowed
		if (head == null)
			return;
		Node current = head, runner;
		while(current != null){
			runner = current;
			while(runner.next != null){
				if (runner.next.data == current.data){
					runner.next = runner.next.next;
				} else {
				runner = runner.next;
				}
			}
			current = current.next;
		}
	}

}
