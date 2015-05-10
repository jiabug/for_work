package Linked_Lists;
/*
 * Write code to partition a linked list around a value x, such that all nodes less than x come before
 * all nodes greater than or equals to x.
 */
public class e4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node partition(Node n, int x){
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		while(n != null){
			Node next = n.next;
			n.next = null;
			if (n.data < x){
				if (beforeStart == null){
					beforeStart = n;//if we use n = n.next in the end instead of n = next. when we set 
					                 // the value of n to the beforeStart, all the link behind n will
					                //be set to beforeStart. But if we set n.next = null, it just 
					                //set the value to beforeStart
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = n;
					beforeEnd = n;
				}
			} else {
				if (afterStart == null){
					afterStart = n;
					afterEnd = afterStart;
				} else {
					afterEnd.next = n;
					afterEnd = n;
				}
			}
			n = next;
		}
		
		if(beforeStart == null){
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	public Node partition_1(Node n, int x){
		Node head = n;
		Node tail = n;
		
		while (n != null){
			Node next = n.next;
			if (n.data < x){
				//insert node at head, insert before the node, so this method is not stable, reverse
				//the sequence of smaller than the x
				n.next = head;
				head = n;
			} else {
				//insert node at tail
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next = null;
		//the head has changed, so we need to return it to the user
		return head;
	}

}
